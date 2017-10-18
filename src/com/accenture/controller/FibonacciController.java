package com.accenture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.accenture.service.FibonacciService;
import com.accenture.service.impl.FibonacciServiceImpl;

@Controller
public class FibonacciController {
	@RequestMapping(value = "/FibonacciController", method = RequestMethod.GET)
	public String fibonacciSequence(@RequestParam("fibonaccilength") String fibonacciLength, ModelMap model,
			HttpServletRequest request) throws IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		long fibolength = 0;
		String errorInfo = null;
		try {
			fibolength = Long.parseLong(fibonacciLength);
			FibonacciService fibo = new FibonacciServiceImpl();
			List<Long> fibolist = fibo.fibonacci(fibolength);
			session.setAttribute("fibolist", fibolist);
			model.addAttribute("fibolist", fibolist);
		} catch (Exception e) {
			errorInfo = e.getMessage();
			session.removeAttribute("fibolist");
			session.setAttribute("errorInfo", errorInfo);
			model.addAttribute("errorInfo", errorInfo);
		}
		return "fibonacciResult";

	}
}
 