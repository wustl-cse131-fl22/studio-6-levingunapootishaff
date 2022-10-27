package studio6.tests;

import studio6.IterativeMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class IterativeGCDTest extends AbstractGCDTest {
	public IterativeGCDTest(int expected, int p, int q) {
		super(expected, p, q);
	}

	@Override
	protected int gcd(int p, int q) {
		return IterativeMethods.gcd(p, q);
	}
}
