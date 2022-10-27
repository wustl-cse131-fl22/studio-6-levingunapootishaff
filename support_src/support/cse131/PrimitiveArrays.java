package support.cse131;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class PrimitiveArrays {
	public static int[] toIntArray(Collection<Integer> collection) {
		return collection.stream().mapToInt(Integer::intValue).toArray();
	}

	public static double[] toDoubleArray(Collection<Double> collection) {
		return collection.stream().mapToDouble(Double::doubleValue).toArray();
	}

	public static List<Integer> toListOfIntegers(int[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}

	public static List<Double> toListOfDoubles(double[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}
}
