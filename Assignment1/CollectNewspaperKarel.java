/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

/*
 * Tuesday July 10th, 2012
 */

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		findNewspaper();
		getNewspaper();
		goback();
	}
	
	private void findNewspaper() {
		/*
		 * Moves Karel to the newspaper
		 */
		
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	private void getNewspaper() {
		/*
		 * Karel picks up newspaper
		 */
		pickBeeper();
	}
	private void goback() {
		/*
		 * Karel goes back to where he started
		 */
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}
	

}
