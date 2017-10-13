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
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.accenture.service.FibonacciSequence;
import com.accenture.xml.FibonacciSequenceRequest;
import com.accenture.xml.FibonacciSequenceResponse;

public class FibonacciSequenceImpl implements FibonacciSequence {
	
	
	public static final Logger LOGGER = Logger.getLogger(FibonacciSequenceImpl.class);
	public static final String LOG4JPROPERTIES="log4j.properties";

	public void solve(String inputFilePath, String outputDirPath) {
		JAXBContext context;
		JAXBContext context1;
		FibonacciSequenceResponse fibonacciSequenceResponse = new FibonacciSequenceResponse();
		PropertyConfigurator.configure(LOG4JPROPERTIES);
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			 
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					outputDirPath)));
			context = JAXBContext.newInstance(FibonacciSequenceRequest.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File(inputFilePath);
			if (file.exists()) {
				// If the file already exists, output the relevant information of the file 
				LOGGER.info(file.getAbsolutePath());
			
			}
			else {
				LOGGER.info("The file doesn't exists!");
			}
			FibonacciSequenceRequest fibonacciSequenceRequest = (FibonacciSequenceRequest) unmarshaller
					.unmarshal(file);

			
			context1 = JAXBContext.newInstance(FibonacciSequenceResponse.class);
			Marshaller mar1 = context1.createMarshaller();
			StringWriter writer = new StringWriter();
			try {
				LOGGER.info("The Fibonacci sequence's length is: "+fibonacciSequenceRequest.getLength());
				fibonacciSequenceResponse
						.setValues(fibonacci(fibonacciSequenceRequest
								.getLength()));
				
			} catch (Exception e) {

				LOGGER.error(e);
			}
			mar1.marshal(fibonacciSequenceResponse, writer);
			out.println(writer.toString());

		} catch (JAXBException e1) {

			LOGGER.error(e1);
		} catch (IOException e) {

			LOGGER.error(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

					
					LOGGER.error(e);
					
				}
			}
			if (out != null)
				out.close();
		}
	}

	/**
	 * 
	 * @param n
	 * @return
	 * @exception 
	 */
	public  List<Long> fibonacci(long n) {
		PropertyConfigurator.configure(LOG4JPROPERTIES);
		if (n > 0) {
			List<Long> list = new ArrayList<>();
			Long i;
			if (n == 1)
				list.add((long) 0);
			else if (n == 2) {
				list.add((long) 0);
				list.add((long) 1);
			} else {
				int a = 1, b = 1, c = 0;
				list.add((long) 0);
				list.add((long) 1);
				list.add((long) 1);
				for (i = (long) 1; i <= n - 3; i++) {
					c = a + b;
					a = b;
					b = c;
					list.add((long) c);
				}
			}
			LOGGER.info("the Fibonacci sequence is:"+list);
			return list;
		} else {
			throw new IllegalArgumentException(
					"The length of the sequence should be greater than  0");		
		}
	}

}
