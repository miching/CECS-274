/**
 * 
 */

/**
 * The card game Yachtz that rolls 3 dices and checks for winning conditions
 * based off those values
 * 
 * @author michaelching 3/4/2020
 *
 */
public class Yachtz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player p1 = new Player();

		boolean play = true;

		// player wants to play
		while (play) {

			// lets player roll the dices and checks for winning cases
			p1.takeTurn();

			System.out.println("Do you want to play again? Y/N");

			// checks if player wants to play again
			play = CheckInput.getYesNo();

		}

		System.out.println("Game Over!");
		System.out.println("Final Score: " + p1.getPoints());
	}

}
