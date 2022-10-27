package studio6.tests;

import java.util.List;

import studio6.RecursiveMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class RecursiveToReversedTest extends AbstractToReversedTest {
	public RecursiveToReversedTest(List<Integer> xs) {
		super(xs);
	}

	@Override
	protected int[] toReversed(int[] xs) {
		return RecursiveMethods.toReversed(xs);
	}
}
