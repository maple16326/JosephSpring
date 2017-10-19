package com.accenture.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.accenture.controller.JosephController;

@Component
@Aspect
public class LogAspect {
	public static final Logger LOGGER = Logger.getLogger(JosephController.class);

	@Before(value = "execution( * com.accenture.service.impl.*.*(..))")
	public void printServiceStartTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		LOGGER.info("Program service start time：" + df.format(new Date()));

	}

	@After(value = "execution(public * com.accenture.service.impl.*.*(..))")
	public void printServiceEndTime() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		LOGGER.info("Program service end time：" + df.format(new Date()));

	}

	@Before(value = "execution(public * com.accenture.business.impl.*.*(..))")
	public void printBusinessStartTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		LOGGER.info("Program business start time：" + df.format(new Date()));

	}

	@After(value = "execution(public * com.accenture.business.impl.*.*(..))")
	public void printBusinessEndTime() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		LOGGER.info("Program business end time：" + df.format(new Date()));

	}

	@Before(value = "execution(public * com.accenture.controller.*.*(..))")
	public void printControllerStartTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		LOGGER.info("Program controller start time：" + df.format(new Date()));
	}

	@After(value = "execution(public * com.accenture.controller.*.*(..))")
	public void printControllerEndTime() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		LOGGER.info("Program controller end time：" + df.format(new Date()));

	}
}
