package studio6.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.PrimitiveArrays;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public abstract class AbstractToReversedTest {
	private final int[] expecteds;
	private final int[] xs;

	public AbstractToReversedTest(List<Integer> xs) {
		super();
		List<Integer> copy = new ArrayList<>(xs);
		Collections.reverse(copy);
		this.expecteds = PrimitiveArrays.toIntArray(copy);
		this.xs = PrimitiveArrays.toIntArray(xs);
	}

	protected abstract int[] toReversed(int[] xs);

	@Test
	public void test() {
		int[] copyOfXs = Arrays.copyOf(xs, xs.length);
		int[] actuals = toReversed(copyOfXs);

		assertNotSame("\nDo NOT return array parameter.\n", copyOfXs, actuals);

		String mutationMessage = toMessage("Do NOT mutate array parameter.", xs, copyOfXs);
		assertArrayEquals(mutationMessage, xs, copyOfXs);

		String equalityMessage = toMessage("", expecteds, actuals);
		assertArrayEquals(equalityMessage, expecteds, actuals);
	}

	private static String toMessage(String prefix, int[] expected, int[] actual) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append(prefix);
		sb.append("\n");
		sb.append("expected\n");
		sb.append("========\n");
		sb.append(Arrays.toString(expected));
		sb.append("\n\n");
		sb.append("actual\n");
		sb.append("======\n");
		sb.append(Arrays.toString(actual));
		sb.append("\n\n");
		return sb.toString();
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		// odd length test cases
		args.add(new Object[] { Arrays.asList(1) });
		args.add(new Object[] { Arrays.asList(1, 2, 3) });
		args.add(new Object[] { Arrays.asList(1, 2, 3, 4, 5) });
		args.add(new Object[] { Arrays.asList(8, 6, 7, 5, 3, 0, 9) });
		args.add(new Object[] { Arrays.asList(7, 7, 7, 93, 11) });
		args.add(new Object[] { Arrays.asList(131, 231, 425) });

		// even length test cases
		args.add(new Object[] { Arrays.asList(1, 2) });
		args.add(new Object[] { Arrays.asList(1, 2, 3, 4) });
		args.add(new Object[] { Arrays.asList(1, 2, 3, 4, 5, 6) });
		args.add(new Object[] { Arrays.asList(2, 4, 6, 8) });
		args.add(new Object[] { Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21) });

		// random test cases
		Random random = new Random();
		for (int i = 0; i < 10; ++i) {
			int n = 2 + random.nextInt(8);
			List<Integer> list = new ArrayList<>(n);
			for (int j = 0; j < n; ++j) {
				list.add(-99 + random.nextInt(199));
			}
			args.add(new Object[] { list });
		}

		// special case: 0 length
		args.add(new Object[] { Arrays.asList() });
		return args;
	}
}
