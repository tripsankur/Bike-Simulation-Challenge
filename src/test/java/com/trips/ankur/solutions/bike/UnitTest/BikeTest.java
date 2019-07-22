/**
 * 
 */
package com.trips.ankur.solutions.bike.UnitTest;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import com.trips.ankur.solutions.bikesimulation.Bike;
import com.trips.ankur.solutions.bikesimulation.Board;
import com.trips.ankur.solutions.bikesimulation.Position;
import com.trips.ankur.solutions.bikesimulation.exceptions.InvalidActionException;
import com.trips.ankur.solutions.bikesimulation.exceptions.InvalidFacingException;
import com.trips.ankur.solutions.bikesimulation.exceptions.InvalidPositionException;

/**
 * @author tripaank
 *
 */
public class BikeTest {

	private Bike bike;
	private Board board=new Board(7,7, new ArrayList<Position>()); //Creating 7x7 board

	@Test
	public void test_SetPosition() throws Exception {
		bike = new Bike(board);
		assertThat(bike, notNullValue());

		bike.process("PLACE 1,2,NORTH");
		
		// Validate all set values
		assertEquals(1, bike.getPosition().getX());
		assertEquals(2, bike.getPosition().getY());
		assertEquals("NORTH", bike.getFacing().toString());
	}

	@Test(expected = InvalidPositionException.class)
	public void test_SetPositionX_Exception() {
		bike = new Bike(board); 
		bike.process("PLACE 0,8,NORTH"); // X is more than endX - of the board
	}

	@Test(expected = InvalidPositionException.class)
	public void test_SetPositionY_Exception() {
		bike = new Bike(board); 
		bike.process("PLACE 9,0,NORTH");// X is more than endX -
	}

	@Test(expected = InvalidFacingException.class)
	public void test_SetPositionFacing_Exception() {
		bike = new Bike(board); 
		String command = "PLACE 0,0,NOTHING";
		bike.process(command); // X is more than endX -
	}

	@Test
	public void test_Process() {
		String command = "PLACE 0,0,NORTH";
		bike = new Bike(board); 
		// Initial position Testing
		

		bike.process(command);
		assertEquals("(0,0), NORTH", bike.returnPosition()); 

		// Command with Steps
		// Move testing
		bike.process("TURN_LEFT");
		bike.process("TURN_RIGHT");
		bike.process("FORWARD");
		assertEquals("(0,1), NORTH", bike.returnPosition());

		// Only Move testing
		bike.process("FORWARD");
		assertEquals("(0,2), NORTH", bike.returnPosition());

		// Left Turn testing

		// N -> W Left turn
		bike.process("TURN_LEFT"); // Move testing
		assertEquals("(0,2), WEST", bike.returnPosition());
		
		// W -> S Left turn
		bike.process("TURN_LEFT"); // Move testing
		assertEquals("(0,2), SOUTH", bike.returnPosition());
		
		
		// S -> E Left turn
		bike.process("TURN_LEFT"); // Move testing
		assertEquals("(0,2), EAST", bike.returnPosition());
		// E -> N Left turn
		bike.process("TURN_LEFT"); // Move testing
		assertEquals("(0,2), NORTH", bike.returnPosition());

		// Right turn testing

		// N -> E Right turn testing
		bike.process("TURN_RIGHT"); // Move testing
		assertEquals("(0,2), EAST", bike.returnPosition());

		// E -> S Right turn testing
		bike.process("TURN_RIGHT"); // Move testing
		assertEquals("(0,2), SOUTH", bike.returnPosition());

		// S -> W Right turn testing
		bike.process("TURN_RIGHT"); // Move testing
		assertEquals("(0,2), WEST", bike.returnPosition());

		// W -> N Right turn testing
		bike.process("TURN_RIGHT"); // Move testing
		assertEquals("(0,2), NORTH", bike.returnPosition());
		
		
		// Invalid Move testing
		bike.process("PLACE 7,7,NORTH"); // Move testing
		bike.process("FORWARD"); // Move testing
		assertEquals("(7,7), NORTH", bike.returnPosition());

	}



	@Test
	public void test_returnPosition() {

		bike = new Bike(board); // Size of plateau being passed
		// Initial position Testing
		String command = "PLACE 0,0,NORTH";
		bike.process(command);
		assertEquals("(0,0), NORTH", bike.returnPosition());

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		command = "GPS_REPORT";
		bike.process(command);
		assertEquals("(0,0), NORTH", outContent.toString().trim());

	}
}
