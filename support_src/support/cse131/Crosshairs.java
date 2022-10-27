package support.cse131;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Crosshairs {
	public static void drawCrosshairs(double[] position, double halfRadius) {
		StdDraw.line(position[0], position[1] - halfRadius, position[0], position[1] + halfRadius);
		StdDraw.line(position[0] - halfRadius, position[1], position[0] + halfRadius, position[1]);
	}

	public static void drawMultipleCrosshairs(double[][] positions, double halfRadius) {
		for (double[] position : positions) {
			drawCrosshairs(position, halfRadius);
		}
	}
}
