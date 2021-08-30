/**
 * Michael Ching
 * 2/23/2020
 * 
 * Four recursive problems. 
 * Add your two facade functions.
 * Add your code to the four functions given below.
 * Do not change any part of the function headers (name, parameters, or return type).
 * Do not change any part of the main.
 */
public class Recursion2 {	public static void main( String[] args ) {		int [] array = { 46, 22, 7, 58, 91, 55, 31, 84, 12, 78 };		if( findMax( array ) == 91 ) {			System.out.println( "findMax is correct!" );		}		if( reverseStr( "Hello" ).equals( "olleH" ) ) {			System.out.println( "reverseString1 is correct!" );		}			if( charFrequency( "The quick brown fox jumps over the lazy dog.", 'o' ) == 4 ) {			System.out.println( "charFrequency1 is correct!" );		}
		if( findMin( array ) == 7 ) {			System.out.println( "findMin is correct!" );		}		if( reverseStr( "pupils" ).equals( "slipup" ) ) {			System.out.println( "reverseString2 is correct!" );		}			if( charFrequency( "The quick brown fox jumps over the lazy dog.", 'e' ) == 3 ) {			System.out.println( "charFrequency2 is correct!" );		}	}
	//Write your facade functions here

	/**
	 * Calls function maxArray to hide certain parameters
	 * @param array An array holding values
	 * @return the max value in the array
	 */
	public static int findMax(int [] array)
	{
		
		return maxArray (array, 0, array[0]);
		
	}
	
	/**
	 * Calls function minArray to hide certain parameters
	 * @param array An array holding values
	 * @return the min value in the array
	 */
	public static int findMin(int [] array)
	{
		
		return minArray (array, 0 ,array[0]);
		
	}


	/** Finds the maximum value in an array	 * @param array array of values (sorted or unsorted)	 * @param i iterator	 * @param max maximum value found so far	 * @return maximum value	 */	private static int maxArray( int [] array, int i, int max ) {
			
		//iterate through the array
		if(i < array.length)
		{
			
			//the current array value is greater than the current max value
			if(max < array [i])
			{
				
				return maxArray (array, (i + 1), array[i] );
				
			}
			
			else
			{
				
				return maxArray (array, (i + 1), max );
				
			}
			
		}
		
		else
		{
			
			//largest value found
			return max;
			
		}
			}
	/** Finds the maximum value in an array	 * @param array array of values (sorted or unsorted)	 * @param i iterator	 * @param min maximum value found so far	 * @return minimum value	 */	private static int minArray( int [] array, int i, int min ) {
			 
		//iterate through array
		if(i < array.length)
		{
			
			//the current array value is smaller than the current smallest value
			if(min > array [i])
			{
				
				return minArray (array, (i + 1), array[i] );
				
			}
			
			else
			{
				
				return minArray (array, (i + 1), min );
				
			}
			
		}
		else
		{
			
			//smallest value founded
			return min;
			
		}
		
			}	/** Reverses a string	 * @param s the string to reverse	 * @return the reversed string	 */	public static String reverseStr( String s ) {		
		//the string contains characters
		if(s.length() > 0)
		{
			
			//get the last letter and remove the last letter each time
			return s.substring(s.length()-1) + reverseStr (s.substring(0,s.length()-1 ) );
			
		}
		
		else
		{
			
			return s;
			
		}
		
		
			}	/** Returns the number of times c appears in the string str	 * @param str string to test	 * @param c character to find	 * @return number of times the character appeared in the string	 */	public static int charFrequency( String str, char c ) {			
		//if the character is in the string
		if(str.indexOf (c) != -1 )
		{
			
			//add one each time character occurs, and remove it from rest of string to find next occurrence
			return 1 + charFrequency(str.substring( str.indexOf(c) +1 ), c);
			
		}
		
		else
		{
			
			return 0;
			
		}
			}}