package studio6.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public abstract class AbstractGeometricSumTest {
	private final double expected;
	private final int n;

	public AbstractGeometricSumTest(double expected, int n) {
		super();
		this.expected = expected;
		this.n = n;
	}

	protected abstract double geometricSum(int n);

	@Test
	public void test() {
		double reasonableDelta = 0.0001;
		assertEquals(expected, geometricSum(n), reasonableDelta);
	}

	@Parameterized.Parameters(name = "{0} == geometricSum({1})")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		args.add(new Object[] { 0.0, 0 });
		args.add(new Object[] { 0.5, 1 });
		args.add(new Object[] { 0.75, 2 });
		args.add(new Object[] { 0.875, 3 });
		args.add(new Object[] { 0.9375, 4 });
		args.add(new Object[] { 0.96875, 5 });
		args.add(new Object[] { 0.984375, 6 });
		args.add(new Object[] { 0.9921875, 7 });
		args.add(new Object[] { 0.99609375, 8 });
		args.add(new Object[] { 0.998046875, 9 });

		return args;
	}
}
