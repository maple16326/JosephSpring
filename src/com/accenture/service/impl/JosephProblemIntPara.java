package com.accenture.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.accenture.xml.JosephProblemRequest;
import com.accenture.xml.JosephProblemResponse;

public class JosephProblemIntPara implements Problem {
	private static final Logger LOGGER = Logger.getLogger(JosephProblemIntPara.class);
	private static final String LOG4J_PROPERTIES = "log4j.properties";
	public void solve(String inputFilePath, String outputDirPath) {
		BufferedReader in = null;
		PrintWriter out = null;
		JAXBContext context;
		JAXBContext context1;
		JosephProblemResponse josephProblemResponse = new JosephProblemResponse();
		PropertyConfigurator.configure(LOG4J_PROPERTIES);

		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					outputDirPath)));
			context = JAXBContext.newInstance(JosephProblemRequest.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File(inputFilePath);
			JosephProblemRequest josephProblemRequest = (JosephProblemRequest) unmarshaller
					.unmarshal(file);
			context1 = JAXBContext.newInstance(JosephProblemResponse.class);
			Marshaller mar1 = context1.createMarshaller();
			StringWriter writer = new StringWriter();
			try {
				josephProblemResponse.setPeople(solveJosephProblem(
						josephProblemRequest.getCircle().getPeoples(),
						josephProblemRequest.getCircle().getInterval(),
						josephProblemRequest.getCircle().getStartNo()));
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

			mar1.marshal(josephProblemResponse, writer);
			out.println(writer.toString());
		} catch (JAXBException e1) {
			LOGGER.error(e1.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
				}
			}
			if (out != null)
				out.close();
		}

	}

	/**
	 * Using ArrayList to solve Joseph problem 
	 * @param persons 
	 * @param interval
	 * @return lastPerson
	 */
	public String solveJosephProblem(String[] persons, int interval, int startNo)
			throws Exception {
		if (persons != null && interval > 0 && startNo >= 0) {
			List<String> start = new ArrayList<String>();
			start.addAll(Arrays.asList(persons));
			int k = startNo - 1;
			LOGGER.info(start);
			while (start.size() > 1) {
				k = k + interval;
				k = k % (start.size()) - 1;
				if (k < 0) {
					LOGGER.info("reomove:" + start.get(start.size() - 1));
					start.remove(start.size() - 1);
					k = 0;
				} else {
					LOGGER.info("reomove:" + start.get(k));
					start.remove(k);
				}

			}
			LOGGER.info("the last element is:" + start.get(0));

			return start.get(0);
		} else if (persons == null) {
			throw new IllegalArgumentException("Array cannot be null");

		} else if (interval <= 0) {
			throw new IllegalArgumentException("The interval must be greater than 0 ");
		} else {
			throw new IllegalArgumentException("The startNo must be greater than or equal to 0");
		}

	}

}
