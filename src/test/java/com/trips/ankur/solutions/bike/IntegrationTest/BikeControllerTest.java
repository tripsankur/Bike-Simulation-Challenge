package com.trips.ankur.solutions.bike.IntegrationTest;

import static org.junit.Assert.*;
import java.io.File;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.trips.ankur.solutions.bikesimulation.exceptions.NotEnoughArgumentException;
import com.trips.ankur.solutions.bikesimulation.main.BikeController;

public class BikeControllerTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void testMain_NotEnoughArguments() throws Throwable {
		String[] args = new String[] {};
		// Not Enough Arguments
		expectedEx.expectCause(IsInstanceOf.<Throwable>instanceOf(NotEnoughArgumentException.class));
		AbstractMainTests.executeMain(BikeController.class, args);
	}

	@Test
	public void testMain() throws Throwable {
		String[] args = new String[1];

		File input = new File(Thread.currentThread().getContextClassLoader().getResource("test.txt").toURI());

		args[0] = input.getAbsolutePath();
		//System.out.println(args[0]);

		String[] result = AbstractMainTests.executeMain(BikeController.class, args);
		assertEquals(result[0], "(0,6), NORTH");
		//assertEquals(result[1], "5 1 E");


		//Scenario 2
		input = new File(Thread.currentThread().getContextClassLoader().getResource("test2.txt").toURI());
		args[0] = input.getAbsolutePath();
		System.out.println(args[0]);

		result = AbstractMainTests.executeMain(BikeController.class, args);
		assertEquals(result[0], "(0,0), WEST");

		//Scenario 2
		input = new File(Thread.currentThread().getContextClassLoader().getResource("test3.txt").toURI());
		args[0] = input.getAbsolutePath();
		System.out.println(args[0]);

		result = AbstractMainTests.executeMain(BikeController.class, args);
		assertEquals(result[0], "(3,3), NORTH");
	}

}
