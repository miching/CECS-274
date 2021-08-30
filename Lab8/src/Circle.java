/**
 * 
 */

/**
 * @author michaelching 04/12/2020 
 * 			Circle class that holds the coordinates (x,y)
 *          and radius value of a circle
 *
 */
public class Circle {

	// circle values of x, y, and the radius
	private int x;
	private int y;
	private int radius;

	/**
	 * Constructor with variables x,y, and radius
	 * 
	 * @param x      the x value of the center of circle
	 * @param y      the y value of the center of circle
	 * @param radius the radius of the circle
	 */
	public Circle(int x, int y, int radius) {

		// sets current circle to passed in values
		this.x = x;
		this.y = y;
		this.radius = radius;

	}

	/**
	 * Compares a circle and an object to see if they are equal
	 * 
	 * @param o Object that is passed in
	 * 
	 */
	@Override
	public boolean equals(Object o) {

		// checks to see if o is a Circle
		if (o instanceof Circle) {

			// cast o to Circle
			Circle circle = (Circle) o;

			// both circles have same values
			if ((this.x == circle.x) && (this.y == circle.y) && (this.radius == circle.radius)) {

				return true;

			}

			// circles have different values
			else {

				return false;

			}

		}

		// object passed in is not a Circle
		else {

			return false;

		}

	}

	/**
	 * Returns the values of the circle in the form (x,y) R = radius
	 */
	@Override
	public String toString() {

		return ("(" + x + "," + y + ") R = " + radius);

	}

}
