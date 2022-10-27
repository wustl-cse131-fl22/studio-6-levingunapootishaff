package test.cse131;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dennis Cosgrove
 */
public class Tests {
	public static <T extends Comparable<T>> void assertEqualsIndependentOfOrder(String message, List<T> expected, List<T> actual) {
		List<T> expectedSorted = toSorted(expected);
		List<T> actualSorted = toSorted(actual);
		assertEquals(message, expectedSorted, actualSorted);
	}

	private static <T extends Comparable<T>> List<T> toSorted(List<T> list) {
		List<T> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList);
		return sortedList;
	}
}
