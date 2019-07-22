# Bike Simulation Challenge

## Introduction

This application is written in Java 8. It performs below functions.

* It takes the input file as the argument.
* Requirement

      Design and develop an application simulating a bike driving on a 7 x 7 grid.
      The bike is free to move around the grid but must be prevented from exiting the grid.
      Any movement that would cause the bike to leave the grid must be prevented,
      however further valid movement must still be allowed.
      The following commands must be supported by the application:
      
      * PLACE <X>,<Y>,<Facing-direction>
      * FORWARD
      * TURN_LEFT
      * TURN_RIGHT
      * GPS_REPORT
  
      • PLACE will put the bike at position (X,Y) facing NORTH, SOUTH, EAST or WEST, where
      (0,0) is the south-west corner.
      • The application should discard all commands until a valid PLACE command has been
      executed. The application should also ignore all invalid commands.
      • After the initial PLACE command any sequence of commands may be issued (and in any
      order) including another PLACE command.
      • FORWARD will move the bike one unit forward in the direction it is currently facing.
      • TURN_LEFT and TURN_RIGHT will rotate the bike in the specified direction without
      changing its position on the grid.
      • GPS_REPORT will output the bike's position and facing in the following format:
      (<X>, <Y>), <Facing-direction>
      
      The bike must not exit the grid during movement. This includes the PLACE command.
      Any move that would cause the bike to leave the grid must be ignored.
      Input for the bike can be from a file

    
* This application prints the final position of each of the bike as output on the terminal once GPS_REPORT is processed.

## Assumptinos

* The size of the Board(plateau) is 7x7.
* If the command 'M' takes the cordinate to out of the Board(plateau), the action will not be performed.
* If the intial position of the bike is being sent as invalid coordinate (Not in the Board(plateau)), InvalidPositionException is thrown.
* Input format is defined and followed. (Exception is thrown in case the input format is not correct.)
* Excpetion InvaliActionException is thrown by the application, if the Action is different than 'L','R','M'.

## How it works

* BikeController : This is the main class, which starts the application. Input file is passed as argument to this class.
* Board : Initially a 7x7 board is provided, which stores all the available position for the bike to travel.
* Position : This class creates the position object, stores the x, y coordinate and provides methods to increase/decrease the coordinates.
* Bike: This class is contains all methods to perform operations on the bike. It maintains the position and facing of the bike and controle the movements and tracks the action being performed on the bike.


## How to use the Application

This application takes 1 argument as below.

* Argument 1 - Manadatory - Complete Path of the Input File

## Future Possible Improvements 
* Program to have configuration file from where it takes the parameters.
* Program to have defined input directory, and it should poll the directory for any new input file and process the input file once it it available.
* Application can be imporved to run more than one bike at a time on the given board.


## How to Build and Run.

To Build the pacakge 

*mvn clean compile assembly:single*

To Run the application

*     java -jar {target_dir}/BikeSimulation-0.0.1-SNAPSHOT <Argument 1> 

  example : 
  java -jar C:\Users\tripaank\eclipse-workspace-jee\BikeSimulationChallenge\target\BikeSimulation-0.0.1-SNAPSHOT "C:\\Users\\tripaank\\Documents\\test.txt"

## Testing 

Unit testing and Integration testing has been performed and the src is present in the application src/test/ directory.

  * All actions validated and tested.
  * All Exceptions validated and tested.
  * Possible error scenarios validated and tested.

  



