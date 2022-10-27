package studio6.tests;

import java.util.List;

import studio6.IterativeMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class IterativeToReversedTest extends AbstractToReversedTest {
	public IterativeToReversedTest(List<Integer> xs) {
		super(xs);
	}

	@Override
	protected int[] toReversed(int[] xs) {
		return IterativeMethods.toReversed(xs);
	}
}
