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
public class Recursion2 {
		if( findMin( array ) == 7 ) {
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
		
	/** Finds the maximum value in an array
			 
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
		