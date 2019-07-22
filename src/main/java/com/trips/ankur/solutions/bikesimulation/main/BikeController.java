package com.trips.ankur.solutions.bikesimulation.main;


import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

import com.trips.ankur.solutions.bikesimulation.Bike;
import com.trips.ankur.solutions.bikesimulation.Board;
import com.trips.ankur.solutions.bikesimulation.Position;
import com.trips.ankur.solutions.bikesimulation.exceptions.NotEnoughArgumentException;


/**
 * Rover controller - Main class
 * @author tripaank
 *
 */

public class BikeController {
	private static String input;
	public static void main(String args[]) throws Exception {

		
		if (args.length != 1) {
			System.out.println("Usage Instructions :");
			System.out.println("Please provide 1 arugments as below.");
			System.out.println("Argument 1: Input file complete path.");
			throw new NotEnoughArgumentException("Not Enough Arguments Passed to the application.");
		}
		validateArguements(args);
		
		
		
		//File file = new File("C:\\Users\\tripaank\\Documents\\test.txt");
		File file = new File(input);
		LineIterator it = FileUtils.lineIterator(file, StandardCharsets.UTF_8.name());

		
		//Create a board of 7x7
		int endX=7;
		int endY=7;
		
		Board board=new Board(endX,endY, new ArrayList<Position>());
		
		//Creating Bike on the Board
		Bike bike = new Bike(board);
		
		while(it.hasNext()) {
			bike.process(it.nextLine());
		}
	}
	
	/**
	 * This method Validates the arguments.  
	 * 
	 * @param args
	 */
	private static void validateArguements(String[] args) {
		input = StringUtils.defaultString(args[0]);
		if (StringUtils.isAnyBlank(input)) {
			System.out.println("[validateArguements] All manadatory parameters must be specified.");
			System.out.println("[validateArguements] input file = " + input);
			throw new NotEnoughArgumentException("[validateArguements] Empty Arguments passed to the application.");
		}
	}
}

