package com.accenture.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

	public static final String APPLICATION_JSON_CHAR_SET_UTF_8 = "application/json;char-set=utf-8";

	public static final Logger LOGGER = Logger.getLogger(JosephController.class);
	public static final String LOG4JPROPERTIES = "log4j.properties";
	private JosephBusiness josephBusniness;
	private BusinessException businessException;

	public JosephBusiness getJosephBusniness() {
		return josephBusniness;
	}

	public void setJosephBusniness(JosephBusiness josephBusniness) {
		this.josephBusniness = josephBusniness;
	}

	public BusinessException getBusinessException() {
		return businessException;
	}

	public void setBusinessException(BusinessException businessException) {
		this.businessException = businessException;
	}

	@RequestMapping(value = "/Josephcontroller", method = RequestMethod.POST)
	@ResponseBody
	public JosephProblemResponse josephProblem(@Valid @RequestBody JosephProblemRequest josephProblemRequest,
			BindingResult bindingResult,Errors errors) {
		JosephProblemResponse josephProblemResponse = new JosephProblemResponse();
		List<Error> errorList=new ArrayList<Error>();
		
		if (errors.hasErrors()) {
			LOGGER.error("THE INPUT IS INVALID!");
			List<ObjectError> error=bindingResult.getAllErrors();
			List<FieldError>fieldErrors=bindingResult.getFieldErrors();
			for(FieldError fieldError:fieldErrors)
			{
				Error jError=new Error();
				LOGGER.error("The invalid field is:"+fieldError.getField()+fieldError.getDefaultMessage());
				jError.setField(fieldError.getField());
				jError.setMessage(fieldError.getDefaultMessage());
				errorList.add(jError);
				
			}
			josephProblemResponse.setErrors(errorList);
			for(int i=0;i<bindingResult.getAllErrors().size();i++){
				LOGGER.error(error.get(i).getDefaultMessage());
			}
			josephProblemResponse.setPerson(null);
			return josephProblemResponse;

		} else {
			
			try {
				josephProblemResponse = josephBusniness.doJosephCalcu(josephProblemRequest);

			} catch (BusinessException e) {
				LOGGER.error("failed", e);
			}
			return josephProblemResponse;
		}

	}
}
