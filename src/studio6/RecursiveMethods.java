package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {
	
	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
	// FIXME compute the geometric sum for the first n terms recursively
			if(n<=0) {
				return 0;
			}
			double sum = Math.pow(.5, n); //doing 1/2 to the power of n each time
			return sum += geometricSum(n-1);	
	}

	
	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
	// FIXME compute the gcd of p and q using recursion
			if(p%q==0) {
				return q;
			}
			return gcd(q, p%q);
	}

	
	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reversed = new int[array.length];
		if(array.length==0) {
			return reversed;
		}
		return helper(array, reversed, 0);
	}
	// FIXME create a helper method that can recursively reverse the given array
	public static int[] helper(int[] array, int[] reversed, int n) {
		if(array.length/2<n) {
			return reversed;
	}
		reversed[n] = array[array.length-1-n]; //
		reversed[array.length-1-n] = array[n];
		return helper(array, reversed, n+1);
	}

	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		
			if(radius<radius-.5) { //should have been radius <= radiusMinimumDrawingThreshold
				StdDraw.circle(xCenter, yCenter, radius);
			}
			else {
				StdDraw.circle(xCenter, yCenter+radius, radius);
				StdDraw.circle(xCenter+radius, yCenter, radius);
				StdDraw.circle(xCenter, yCenter-radius, radius);
				StdDraw.circle(xCenter-radius, yCenter, radius);
				
				circlesUponCircles(xCenter, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			}
	}

}
