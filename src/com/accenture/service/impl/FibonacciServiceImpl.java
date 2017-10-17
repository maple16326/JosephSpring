package com.accenture.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.accenture.service.FibonacciService;


public class FibonacciServiceImpl implements FibonacciService {
	
	
	private static final String THE_LENGTH_OF_THE_SEQUENCE_SHOULD_BE_GREATER_THAN_0 = "The length of the sequence should be greater than  0";
	private static final String THE_FIBONACCI_SEQUENCE_IS = "the Fibonacci sequence is:";
	public static final Logger LOGGER = Logger.getLogger(FibonacciServiceImpl.class);

	/**
	 * 
	 * @param n
	 * @return
	 * @exception 
	 */
	public  List<Long> fibonacci(long n) {
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
			LOGGER.info(THE_FIBONACCI_SEQUENCE_IS+list);
			return list;
		} else {
			throw new IllegalArgumentException(
					THE_LENGTH_OF_THE_SEQUENCE_SHOULD_BE_GREATER_THAN_0);		
		}
	}

}
