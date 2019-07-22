package com.trips.ankur.solutions.bikesimulation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Position on the plataeu
 * @author tripaank
 *
 */

@Data
@AllArgsConstructor
public class Position {
	private int x = 0;
	private int y = 0;
	
	
	public void increaseX() {
		this.x++;
	}
	
	public void increaseY() {
		this.y++;
	}
	
	public void decreaseX() {
		this.x--;
	}
	
	public void decreaseY() {
		this.y--;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
	
	
}
