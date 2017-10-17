package com.accenture.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.accenture.business.JosephBusiness;
import com.accenture.dto.Error;
import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;

import com.accenture.exception.BusinessException;

@Controller
public class JosephController {

	private static final String SOMETHING_WENT_WRONG = "Something went wrong:";
	private static final String THE_ERROR_MESSAGE_IS = "The error message is:";
	private static final String THE_INVALID_FIELD_IS = "The invalid field is:";
	public static final String APPLICATION_JSON_CHAR_SET_UTF_8 = "application/json;char-set=utf-8";
	public static final Logger LOGGER = Logger.getLogger(JosephController.class);
	private JosephBusiness josephBusniness;

	public JosephBusiness getJosephBusniness() {
		return josephBusniness;
	}

	public void setJosephBusniness(JosephBusiness josephBusniness) {
		this.josephBusniness = josephBusniness;
	}

	@RequestMapping(value = "/Josephcontroller", method = RequestMethod.POST)
	@ResponseBody
	public JosephProblemResponse josephProblem(@Valid @RequestBody JosephProblemRequest josephProblemRequest,
			BindingResult bindingResult, Errors errors) {
		JosephProblemResponse josephProblemResponse = new JosephProblemResponse();
		List<Error> errorList = new ArrayList<>();

		if (errors.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				Error jError = new Error();
				LOGGER.error(THE_INVALID_FIELD_IS + fieldError.getField() + THE_ERROR_MESSAGE_IS
						+ fieldError.getDefaultMessage());
				jError.setField(fieldError.getField());
				jError.setMessage(fieldError.getDefaultMessage());
				errorList.add(jError);

			}
			josephProblemResponse.setErrors(errorList);
			josephProblemResponse.setPerson(null);

		}

		try {
			josephProblemResponse = josephBusniness.doJosephCalcu(josephProblemRequest);

		} catch (BusinessException e) {
			LOGGER.error(SOMETHING_WENT_WRONG, e.getCause());
		}

		return josephProblemResponse;

	}
}
