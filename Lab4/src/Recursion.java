/**
 * Michael Ching 
 * 2/16/2020
 * 
 * Three recursive problems. Add your code to the three functions given below.
 * Do not change any part of the function headers (name, parameters, or return
 * type). Do not change any part of main.
 */
public class Recursion {
	public static void main(String[] args) {
		if (addDigits(428) == 14) {
			System.out.println("addDigits1 is correct!");
		}
		if (revFibonacci(0, 1, 1, 5) == 5) {
			System.out.println("revFib1 is correct!");
		}
		if (binToDec("1101100") == 108) {
			System.out.println("binToDec1 is correct!");
		}
		if (addDigits(321) == 6) {
			System.out.println("addDigits2 is correct!");
		}
		if (revFibonacci(0, 1, 1, 10) == 55) {
			System.out.println("revFib2 is correct!");
		}
		if (binToDec("1011101") == 93) {
			System.out.println("binToDec2 is correct!");
		}
	}

	/**
	 * Finds the sum of the digits of num
	 * 
	 * @param num value to find the sum of
	 * @return the sum of the digits
	 */
	public static int addDigits(int num) {

		// num is a number larger than 0
		if (num > 0) {

			// get the smallest digit plus the next digit
			return (num % 10) + addDigits((int) num / 10);

		}

		// num is a number smaller/equal to zero
		else {

			return 0;

		}

	}

	/**
	 * Finds the nth Fibonacci value
	 * 
	 * @param f1 n-2 Fibonacci value
	 * @param f2 n-1 Fibonacci value
	 * @param c  counter
	 * @param n  the number c should count up to
	 * @return the nth Fibonacci value
	 */
	public static int revFibonacci(int f1, int f2, int c, int n) {

		// if at correct Fiboncacci number
		if (c + 1 == n) {

			return f1 + f2;

		}

		// f2 parameter will be current f2 + f1, while f1 parameter will become the
		// current value at f2
		return revFibonacci(f2, (f1 + f2), (c + 1), n);

	}

	/**
	 * Converts a binary string to decimal
	 * 
	 * @param bin the binary string
	 * @return the decimal value
	 */
	public static int binToDec(String bin) {

		// checks that string bin is longer than length 0
		if (bin.length() > 0) {

			// checks if the first index is char 1
			if (bin.indexOf('1') == 0) {

				// the power that will be raised
				int n = bin.length() - 1;
				return ((int) Math.pow(2, n)) + binToDec(bin.substring(1));

			}

			// if the value at index 0 is not of value 1
			else {

				return (0) + binToDec(bin.substring(1));

			}

		}

		// the string is of length 0
		else {

			return 0;

		}

	}
}
