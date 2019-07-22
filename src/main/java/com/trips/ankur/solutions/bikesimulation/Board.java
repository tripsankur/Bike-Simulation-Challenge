package com.trips.ankur.solutions.bikesimulation;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Board {
	private int endX = Integer.MAX_VALUE;
	private int endY = Integer.MAX_VALUE;
	List<Position> occupied=  new ArrayList<>();
	
	
	public boolean isPositionOccupied(Integer x, Integer y) {
		return (occupied.contains(new Position(x,y)) || x > endX || y > endY || x < 0 || y < 0 );
	}
	
}
