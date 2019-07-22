package com.trips.ankur.solutions.bikesimulation;


import com.trips.ankur.solutions.bikesimulation.exceptions.InvalidActionException;
import com.trips.ankur.solutions.bikesimulation.exceptions.InvalidFacingException;
import com.trips.ankur.solutions.bikesimulation.exceptions.InvalidPositionException;


import lombok.Getter;

import lombok.Setter;

/**
 * MarseRover class to perform action on the Rover
 * @author tripaank
 *
 */
@Getter
@Setter

public class Bike implements CommandProcessor{
	private int endX = Integer.MAX_VALUE;
	private int endY = Integer.MAX_VALUE;
	
	private Position position;
	private Facing facing = Facing.NORTH;
	private Board board;
	
	
	public Bike(Board board){
		this.board=board;
		this.endX = board.getEndX();
		this.endY = board.getEndY();
	}
	
	/**
	 * Sets the position of the bike to the defined coordinates and facing
	 * @param x
	 * @param y
	 * @param facing
	 * @throws Exception 
	 */
	
	private void setPosition(Integer x, Integer y, String facing)  {		
		if(!board.isPositionOccupied(x,y)) {
			Position pos= new Position(x,y);
			this.position = pos;
			if(facing.equals(Facing.EAST.toString()) || facing.equals(Facing.WEST.toString())
					|| facing.equals(Facing.NORTH.toString()) || facing.equals(Facing.SOUTH.toString())) {
				this.facing=Facing.valueOf(facing);
				
			} else {
				throw new InvalidFacingException(
						"Incorrect facing of the bike. Facing can only be one of the 'NORTH','WEST','SOUTH','EAST'. ");
			}
		}else {
			throw new InvalidPositionException("Invalid initial Position. Initial Position is not available.");
		}
		
	}
	

	/**
	 * Process the commands given by the controller.
	 * @param commands
	 * @return
	 */
	@Override
	public void process(String commands) {
		String[] command=commands.split(" ");
		
		switch(command[0]) {
			case "PLACE":
				if(command.length == 2) {
					String[] place=command[1].split(",");
					if(place.length != 3) {
						
					}else {
						Integer x=Integer.parseInt(place[0]);
						Integer y=Integer.parseInt(place[1]);
						String facing=place[2];
						setPosition(x, y, facing);				
					}
				}else {
					throw new InvalidActionException("Invalid Action: PLACE command does not contain correct arguments. Format should be PLACE <X>,<Y>,<Facing-direction>.");
				}
				break;
			
			case "FORWARD":
				moveForward();
				break;
			
			case "TURN_LEFT":
				makeLeft();
				break;
				
			case "TURN_RIGHT":
				makeRight();
				break;
			
			case "GPS_REPORT":
				returnPosition();
				break;
				
			default:
				throw new InvalidActionException("Invalid Action: Correct command not provided. List of correct commands are: 1) PLACE <X>,<Y>,<Facing-direction>\r\n" + 
						"2. FORWARD\r\n" + 
						"3. TURN_LEFT\r\n" + 
						"4. TURN_RIGHT\r\n" + 
						"5. GPS_REPORT");
				
		}
		
	}
	

	/**
	 * Returns the current position of the Bike in 'x' 'y' 'facing' format.
	 * @return
	 */
	public String returnPosition() {
		String output=  position.toString()+", " +this.getFacing().toString();
		System.out.println(output);
		return output;
	}
	
	
	
	/**
	 * moves the bike forward
	 */
	private void moveForward() {
		if (this.facing == Facing.NORTH && this.position.getY() < this.endY && !board.isPositionOccupied(position.getX(), position.getY()+1)) {
			this.position.increaseY();
		} else if (this.facing == Facing.EAST && this.position.getX() < this.endX && !board.isPositionOccupied(position.getX()+1, position.getY())) {
			this.position.increaseX();
		} else if (this.facing == Facing.SOUTH && this.position.getY() > 0 && !board.isPositionOccupied(position.getX(), position.getY()-1)) {
			this.position.decreaseY();
		} else if (this.facing == Facing.WEST && this.position.getX() > 0 && !board.isPositionOccupied(position.getX()-1, position.getY())) {
			this.position.decreaseX();
		}
	}
	
	/**
	 * makes the left turn.
	 */
	private void makeLeft() {
		if(this.facing == Facing.NORTH)
			this.facing =Facing.WEST;
		else if(this.facing == Facing.WEST)
			this.facing =Facing.SOUTH;
		else if(this.facing == Facing.SOUTH)
			this.facing =Facing.EAST;
		else if(this.facing == Facing.EAST)
			this.facing =Facing.NORTH;
	}
	
	/**
	 * Makes the right turn.
	 */
	private void makeRight() {
		if(this.facing == Facing.NORTH)
			this.facing =Facing.EAST;
		else if(this.facing == Facing.WEST)
			this.facing =Facing.NORTH;
		else if(this.facing == Facing.SOUTH)
			this.facing =Facing.WEST;
		else if(this.facing == Facing.EAST)
			this.facing =Facing.SOUTH;
	}




	
}
