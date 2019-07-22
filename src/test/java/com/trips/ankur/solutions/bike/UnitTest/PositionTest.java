/**
 * 
 */
package com.trips.ankur.solutions.bike.UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.trips.ankur.solutions.bikesimulation.Position;


/**
 * @author tripaank
 *
 */
public class PositionTest {

	Position pos;
	
	@Test
	public void increaseX_Test() {
		pos = new Position(4, 4);
		pos.increaseX();
		assertEquals(5, pos.getX());
		
	}
	@Test
	public void decreaseX_Test() {
		pos = new Position(4, 4);
		pos.decreaseX();
		assertEquals(3, pos.getX());
	}
	@Test
	public void increaseY_Test() {
		pos = new Position(4, 4);
		pos.increaseY();
		assertEquals(5, pos.getY());
	}
	@Test
	public void decreaseY_Test() {
		pos = new Position(4, 4);
		pos.decreaseY();
		assertEquals(3, pos.getY());
	}

}
