/*
 * Author: Michael Ching
 * Date: 1/24/2020
 * Description: Generating a random number for which the user will try to guess & will tell user whether their
 * guess is too high, too low, or is correct.
 */

import java.util.Scanner;

public class RandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// sets variable counter at one b/c user can be correct on first attempt w/o
		// entering loop
		int counter = 1;

		// sets variable randomNumber between integers (1-100)
		int randomNumber = (int) ((Math.random() * 100) + 1);

		// System.out.println(randomNumber);

		System.out.println("I'm thinking of a number. Guess a value (1-100): ");

		//	Scanner scan = new Scanner(System.in);

		// uses CheckInput class to make sure user input is a number and within range
		// (1-100)
		int input = CheckInput.getIntRange(1, 100);

		// while the user guess doesn't equal generated number
		while (input != randomNumber) {

			if (input > randomNumber) {

				System.out.println("Too high. Guess Again: ");
				input = CheckInput.getIntRange(1, 100);

			}

			else if (input < randomNumber) {

				System.out.println("Too low. Guess Again: ");
				input = CheckInput.getIntRange(1, 100);

			}

			counter++;
		}

		System.out.println("Correct! You got it in " + counter + " tries.");

	}

}
