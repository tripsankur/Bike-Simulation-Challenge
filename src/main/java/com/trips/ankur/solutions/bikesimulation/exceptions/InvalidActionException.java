package com.trips.ankur.solutions.bikesimulation.exceptions;

public class InvalidActionException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 889615702395878814L;

	public InvalidActionException(String message) {
        super(message);
    }
}