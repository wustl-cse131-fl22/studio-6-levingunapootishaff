package studio6.tests;

import studio6.RecursiveMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class RecursiveGCDTest extends AbstractGCDTest {
	public RecursiveGCDTest(int expected, int p, int q) {
		super(expected, p, q);
	}

	@Override
	protected int gcd(int p, int q) {
		return RecursiveMethods.gcd(p, q);
	}
}
