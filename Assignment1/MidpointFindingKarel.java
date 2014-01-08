/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		checkMidpoint();
		while (notFacingSouth()) {
			sweep();
			sweep();
			checkMidpoint();
		}
		clearBeepers();
		finalPosition();
	}
	private void clearBeepers(){
		/*
		 * precondition: facing South, in the middle
		 */
		turnLeft();
		moveAcross();
		turnAround();
		while(frontIsClear()){
			if (beepersPresent()){
				pickBeeper();
			}
			move();
		}
		pickBeeper(); //takes care of beeper at origin
	}
	private void checkMidpoint(){
		/*
		 * precondition: facing east, possibly standing on a beeper (for calls other than the first)
		 * postcondition: if found, face South. If not found, back to original, face east
		 * 
		 */
		move();
		move();
		if (beepersPresent()) {
			moveBackwards();
			putBeeper();
			putBeeper();
			turnRight();
		} else {
			move();
			if (beepersPresent()) {
				moveBackwards();
				putBeeper();
				putBeeper();
				turnRight();
			} else {
				moveBackwards();
				moveBackwards();
				moveBackwards();
			}
		}
	}
	private void moveBackwards(){
		turnAround();
		move();
		turnAround();
	}
	private void sweep(){
		/*
		 * precondition: facing west or east
		 */
		moveAcross();
		while (beepersPresent()){
			moveBackwards();
		}
		putBeeper();
		turnAround();

	}
	private void moveAcross() {
		while (frontIsClear()) {
			move();
		}
	}
	private void finalPosition(){
		/*
		 * precondition: facing west, at origin
		 * postcondition: standing on beeper
		 */
		turnAround();
		while(noBeepersPresent() && frontIsClear()) {
			move();
		}
	}
}