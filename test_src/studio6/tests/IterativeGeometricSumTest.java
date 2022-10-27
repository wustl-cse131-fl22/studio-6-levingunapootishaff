package studio6.tests;

import studio6.IterativeMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class IterativeGeometricSumTest extends AbstractGeometricSumTest {
	public IterativeGeometricSumTest(double expected, int n) {
		super(expected, n);
	}

	@Override
	protected double geometricSum(int n) {
		return IterativeMethods.geometricSum(n);
	}
}
