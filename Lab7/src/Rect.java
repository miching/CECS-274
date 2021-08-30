/**
 * Michael Ching
 * 3/8/2020
 */

/**
 * A class representing a Rectangle
 * 
 * @author michaelching 3/8/2020
 *
 */
public class Rect {

	// width of rectangle
	private int width;

	// height of rectangle
	private int height;

	/**
	 * Constructor
	 */
	public Rect() {

		// set dimensions of rectangle to 0
		width = 0;
		height = 0;

	}

	/**
	 * Overload Constructor
	 * 
	 * @param length size of the rectangle
	 */
	public Rect(int length) {

		// length was a negative value
		if (length < 0) {

			// set dimensions of rectangle to 0
			this.width = 0;
			this.height = 0;

		}

		// length was an appropriate value
		else {

			this.width = length;
			this.height = length;

		}

	}

	/**
	 * Overload constructor
	 * 
	 * @param width  length of the width of rectangle
	 * @param height length of the height of rectangle
	 */
	public Rect(int width, int height) {

		// width was a negative value
		if (width < 0) {

			this.width = 0;

		}

		// width was an appropriate value
		else {

			this.width = width;

		}

		// height was a negative value
		if (height < 0) {

			this.height = 0;

		}

		// height was an appropriate value
		else {

			this.height = height;

		}

	}

	/**
	 * Overload constructor
	 * 
	 * @param rectangle An existing rectangle with declared width and height
	 */
	public Rect(Rect rectangle) {

		// set current dimensions to the dimensions of the explicit rectangle
		this.width = rectangle.width;
		this.height = rectangle.height;

	}

	/**
	 * Getter method for height
	 * 
	 * @return current height
	 */
	public int getHeight() {

		return height;

	}

	/**
	 * Getter method for width
	 * 
	 * @return current width
	 */
	public int getWidth() {

		return width;

	}

	/**
	 * Checks if implicit rectangle dimensions matches with the explicit object
	 * 
	 * @param o An object that may or may not be a rectangle
	 */
	@Override
	public boolean equals(Object o) {

		// checks to see if o is a Rect
		if (o instanceof Rect) {

			// cast o to Rect
			Rect rectangle = (Rect) o;

			// both rectangles have same dimensions
			if ((this.width == rectangle.width) && (this.height == rectangle.height)) {

				return true;

			}

			// rectangles have different dimensions
			else {

				return false;

			}

		}

		// obj passed in is not a Rect
		else {

			return false;

		}

	}

	/**
	 * Compares the height or width of the two rectangles
	 * 
	 * @param rectangle An existing rectangle with set dimensions
	 * @return the difference between either the height or width of the explicit and
	 *         implicit rectangle
	 */
	public int compareTo(Rect rectangle) {

		// the height are the same
		if (this.height == rectangle.height) {

			// the difference in width
			return this.width - rectangle.width;

		}

		// height are different
		else {

			// the difference in height
			return this.height - rectangle.height;

		}

	}

	/**
	 * Increase the dimensions of the rectangle by the same factor
	 * 
	 * @param length the scale to increase the width/height by
	 */
	public void scale(int length) {

		// must increase the size of rectangle
		if (length > 1) {

			this.height *= length;
			this.width *= length;

		}

	}

	/**
	 * Increase the height and width by a scale individually
	 * 
	 * @param width  the scale to increase width by
	 * @param height the scale to increase height by
	 */
	public void scale(int width, int height) {

		// must increase width
		if (width > 1) {

			this.width *= width;

		}

		// must increase height
		if (height > 1) {

			this.height *= height;

		}

	}

	/**
	 * Increase the height and width by adding the sides of an existing rectangle
	 * 
	 * @param rectangle An existing rectangle with set dimensions
	 */
	public void scale(Rect rectangle) {

		// must increase height
		if (rectangle.height > 1) {

			this.height += rectangle.height;

		}

		// must increase width
		if (rectangle.width > 1) {

			this.width += rectangle.width;

		}

	}

}
