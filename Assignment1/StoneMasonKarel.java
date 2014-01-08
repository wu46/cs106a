/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

/*
 * Assignment 1 problem 2
 */

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		fillColumn();
		returnToBottom();
		while (frontIsClear()){
			nextColumn();
		}
	}
	private void fillColumn() {
		/*
		 * Karel will go up column and check beeper is present in each row. Until he hits a wall.
		 * precondition: facing east	
		 */
		turnLeft(); //Make him face north
		//For the first row in the column
		if (noBeepersPresent()) {
			putBeeper();
		}
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
	}
	private void returnToBottom() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	private void nextColumn() {
		movex(4);
		fillColumn();
		returnToBottom();
	}
	private void movex(int units) {
		/*
		 * Allows Karel to move multiple number of steps, specified by units
		 */
		for (int i=0; i<units; i++){
			move();
		}
	}

}
