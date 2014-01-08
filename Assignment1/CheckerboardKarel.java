/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		putBeeper(); 							//Always put beeper at start.
		if (frontIsBlocked() && leftIsClear()){ //Special case for only 1 column
			turnLeft();
			while (frontIsClear()) {
				changeCol();
			}
		} else {
			while (frontIsClear()) {
				changeRow();
			}
		}
	}
	private void placeBeeperRow() {
		/*
		 * Turn around and check behind, to determine whether to put beeper on current
		 */
		turnAround();
		move();
		if (noBeepersPresent()){
			turnAround();
			move();
			putBeeper();
		} else {
			turnAround();
			move();
		}
	}

	private void placeBeeperCorner() {
		/*
		 * Asks Karel to go back one unit and check beeper
		 * Use this to check corners if Karel travels horizontally 
		 */
		if (facingWest()) {
			turnLeft();
			move();
			if (noBeepersPresent()){
				turnAround();
				move();
				putBeeper();
				turnLeft();
			} else {
				turnAround();
				move();
				turnLeft();
			}
		} else {
			turnRight();
			move();
			if (noBeepersPresent()) {
				turnAround();
				move();
				putBeeper();
				turnRight();
			} else {
				turnAround();
				move();
				turnRight();
			}
		}
	}
	private void placeBeeperCorner2() {
		/*
		 * Asks Karel to go back one unit and check beeper
		 * Use this to check corners if Karel travels vertically up and down
		 */
		if (facingNorth()) {
			turnLeft();
			move();
			if (noBeepersPresent()){
				turnAround();
				move();
				putBeeper();
				turnLeft();
			} else {
				turnAround();
				move();
				turnLeft();
			}
		} else {
			turnRight();
			move();
			if (noBeepersPresent()) {
				turnAround();
				move();
				putBeeper();
				turnRight();
			} else {
				turnAround();
				move();
				turnRight();
			}
		}
	}
	private void moveAcross() {
		/*
		 * precondition: facing east or west.
		 * should make karel move the whole world... from bottom left corner to top right corner
		 */
		while (frontIsClear()) {
			move();
			placeBeeperRow();
		}
	}

	private void changeRow() {
		moveAcross();
		if (facingEast()) {
			turnLeft();
			if (frontIsClear()){
				move();
				turnLeft();
				placeBeeperCorner();
			}
		} else {
			turnRight();
			if (frontIsClear()){
				move();
				turnRight();
				placeBeeperCorner();
			}
		}

	}
	private void changeCol() {
		moveAcross();
		if (facingNorth()) {
			turnRight();
			if (frontIsClear()) {
				move();
				turnRight();
				placeBeeperCorner2();
			} 
		} else {
			turnLeft();
			if (frontIsClear()) {
				move();
				turnLeft();
				placeBeeperCorner2();
			}
		}
	}
}
