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
public abstract class AbstractGCDTest {
	private final int a;
	private final int b;
	private final int expected;

	public AbstractGCDTest(int expected, int a, int b) {
		super();
		this.expected = expected;
		this.a = a;
		this.b = b;
	}

	protected abstract int gcd(int p, int q);

	@Test
	public void test() {
		assertEquals(expected, gcd(a, b));
	}

	@Test
	public void testFlipped() {
		assertEquals(expected, gcd(b, a));
	}

	@Parameterized.Parameters(name = "{0} == gcd({1}, {2})")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] { 1, 6, 1 });
		args.add(new Object[] { 9, 27, 36 });
		args.add(new Object[] { 2, 48, 14 });

		// random cases
		args.add(new Object[] { 3, 717, 222 });
		args.add(new Object[] { 1, 123, 859 });
		args.add(new Object[] { 3, 621, 249 });
		args.add(new Object[] { 2, 662, 956 });
		args.add(new Object[] { 1, 777, 530 });
		args.add(new Object[] { 1, 10, 943 });
		args.add(new Object[] { 1, 631, 320 });
		args.add(new Object[] { 20, 940, 900 });
		args.add(new Object[] { 14, 952, 798 });
		args.add(new Object[] { 8, 376, 328 });
		args.add(new Object[] { 1, 299, 446 });
		args.add(new Object[] { 1, 317, 352 });
		args.add(new Object[] { 2, 574, 8 });
		args.add(new Object[] { 16, 656, 528 });
		args.add(new Object[] { 1, 713, 409 });
		args.add(new Object[] { 1, 125, 567 });
		args.add(new Object[] { 1, 493, 152 });
		args.add(new Object[] { 1, 596, 281 });
		args.add(new Object[] { 1, 392, 115 });
		args.add(new Object[] { 1, 76, 577 });
		args.add(new Object[] { 5, 460, 75 });
		args.add(new Object[] { 1, 527, 618 });
		args.add(new Object[] { 1, 59, 533 });
		args.add(new Object[] { 1, 758, 399 });
		args.add(new Object[] { 4, 720, 28 });
		args.add(new Object[] { 2, 166, 460 });
		args.add(new Object[] { 1, 156, 869 });
		args.add(new Object[] { 1, 143, 765 });
		args.add(new Object[] { 1, 226, 967 });
		args.add(new Object[] { 2, 806, 292 });
		args.add(new Object[] { 1, 556, 831 });
		args.add(new Object[] { 1, 335, 123 });
		args.add(new Object[] { 2, 950, 744 });
		args.add(new Object[] { 1, 941, 189 });
		args.add(new Object[] { 1, 112, 797 });
		args.add(new Object[] { 2, 638, 214 });
		args.add(new Object[] { 3, 138, 699 });
		args.add(new Object[] { 1, 16, 175 });
		args.add(new Object[] { 5, 335, 760 });
		args.add(new Object[] { 1, 917, 254 });
		args.add(new Object[] { 1, 812, 795 });
		args.add(new Object[] { 5, 925, 115 });

		return args;
	}
}
