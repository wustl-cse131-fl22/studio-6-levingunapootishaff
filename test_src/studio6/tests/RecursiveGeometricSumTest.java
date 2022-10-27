package studio6.tests;

import studio6.RecursiveMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class RecursiveGeometricSumTest extends AbstractGeometricSumTest {
	public RecursiveGeometricSumTest(double expected, int n) {
		super(expected, n);
	}

	@Override
	protected double geometricSum(int n) {
		return RecursiveMethods.geometricSum(n);
	}
}
