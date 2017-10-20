package com.accenture.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.accenture.service.impl.*;

import com.accenture.exception.NegativeArgumentException;
import com.accenture.exception.NullArgumentValueException;

public class CheckJosephArguTest {
	private static final String PERSONS_IS_NULL = "persons is null! ";
	private static final String AND = "and ";
	private static final String INTERVAL_IS_NOT_A_POSITIVE_NUMBER = "interval is not a positive number";
	private static final String START_NO_IS_NOT_A_POSITIVE_NUMBER = "startNo is not a positive number";
	private static final String INTERVAL_IS_NULL = "interval is null! ";
	private static final String START_IS_NULL = "start is null! ";
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	// start==null;interval!=null;persons!=null
	public void testCheckJosephParameterStart() throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		thrown.expect(NullArgumentValueException.class);
		thrown.expectMessage(START_IS_NULL);
		checkJosephArgu.checkJosephParameter(null, 1, personsStr);

	}

	@Test
	// start!=null;interval==null;persons!=null
	public void testCheckJosephParameterInterval() throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();

		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		thrown.expect(NullArgumentValueException.class);
		thrown.expectMessage(INTERVAL_IS_NULL);
		checkJosephArgu.checkJosephParameter(0, null, personsStr);

	}

	@Test
	// start!=null;interval!=null;persons==null
	public void testCheckJosephParameterPersons() throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();

		thrown.expect(NullArgumentValueException.class);
		thrown.expectMessage(PERSONS_IS_NULL);
		checkJosephArgu.checkJosephParameter(0, 1, null);

	}

	@Test
	// start==null;interval==null;persons!=null
	public void testCheckJosephParameterStartAndInterval()
			throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();

		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		thrown.expect(NullArgumentValueException.class);
		thrown.expectMessage(START_IS_NULL + AND + INTERVAL_IS_NULL);
		checkJosephArgu.checkJosephParameter(null, null, personsStr);
	}

	@Test
	// start==null;interval!=null;persons==null
	public void testCheckJosephParameterStartAndPersons() throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		thrown.expect(NullArgumentValueException.class);
		thrown.expectMessage(START_IS_NULL + AND + PERSONS_IS_NULL);
		checkJosephArgu.checkJosephParameter(null, 1, null);
	}

	@Test
	// start!=null;interval==null;persons==null
	public void testCheckJosephParameterIntervalAndPersons()
			throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		thrown.expect(NullArgumentValueException.class);
		thrown.expectMessage(INTERVAL_IS_NULL + AND + PERSONS_IS_NULL);
		checkJosephArgu.checkJosephParameter(0, null, null);
	}

	@Test
	// start==null;interval==null;persons==null
	public void testCheckJosephParameterAllNull() throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		thrown.expect(NullArgumentValueException.class);
		thrown.expectMessage(START_IS_NULL + AND + INTERVAL_IS_NULL + AND + PERSONS_IS_NULL);
		checkJosephArgu.checkJosephParameter(null, null, null);
	}

	@Test
	// start>0;interval<0
	public void testCheckJosephParameterStartGreaterThanZero()
			throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		thrown.expect(NegativeArgumentException.class);
		thrown.expectMessage(INTERVAL_IS_NOT_A_POSITIVE_NUMBER);
		checkJosephArgu.checkJosephParameter(1, -2, personsStr);

	}

	@Test
	// start<0;interval>0
	public void testCheckJosephParameterIntervalGreaterThanZero()
			throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		thrown.expect(NegativeArgumentException.class);
		thrown.expectMessage(START_NO_IS_NOT_A_POSITIVE_NUMBER);
		checkJosephArgu.checkJosephParameter(-1, 1, personsStr);

	}

	@Test
	// start<0;interval<0
	public void testCheckJosephParameterBothLessThanZero()
			throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		thrown.expect(NegativeArgumentException.class);
		thrown.expectMessage(START_NO_IS_NOT_A_POSITIVE_NUMBER + AND + INTERVAL_IS_NOT_A_POSITIVE_NUMBER);
		checkJosephArgu.checkJosephParameter(-1, -1, personsStr);

	}

	@Test
	// start>0;interval>0
	public void testCheckJosephParameterBothGreaterThanZero()
			throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		Boolean bl = checkJosephArgu.checkJosephParameter(1, 1, personsStr);
		assertEquals(bl, true);
	}
	@Test
	// start>0;interval>0
	public void testCheckJosephParameterBothEqualToZero()
			throws NullArgumentValueException, NegativeArgumentException {
		CheckJosephArgu checkJosephArgu = new CheckJosephArgu();
		List<String> persons = new ArrayList<>();
		persons.add("a");
		persons.add("b");
		String[] personsStr = new String[persons.size()];
		persons.toArray(personsStr);
		Boolean bl = checkJosephArgu.checkJosephParameter(0, 0, personsStr);
		assertEquals(bl, true);
	}
}
