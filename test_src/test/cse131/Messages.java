package test.cse131;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Messages {
	private static <T> String toTextFromList(List<T> list,
			BiFunction<List<T>, Integer, String> toTextFunction) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); ++i) {
			sb.append(toTextFunction.apply(list, i));
		}
		return sb.toString();
	}

	public static <T> String toComplete(String actualOutput, Optional<List<T>> expectedsOpt,
			List<T> cleanedActuals, BiFunction<List<T>, Integer, String> toTextFunction) {
		StringBuilder sb = new StringBuilder();
		if (expectedsOpt.isPresent()) {
			sb.append("=== expected lines ===\n");
			sb.append(toTextFromList(expectedsOpt.get(), toTextFunction));
			sb.append("\n");
		}
		sb.append("=== actual (cleaned) lines ===\n");
		sb.append(toTextFromList(cleanedActuals, toTextFunction));
		sb.append("\n");
		sb.append("=== uncleaned raw output ===\n");
		sb.append(actualOutput);
		sb.append("\n");
		return sb.toString();
	}

	public static <T> String toComplete(String actualOutput, List<T> expecteds,
			List<T> cleanedActuals, BiFunction<List<T>, Integer, String> toTextFunction) {
		return toComplete(actualOutput, Optional.of(expecteds), cleanedActuals, toTextFunction);
	}

	public static String toCompleteFromListOfStrings(String actualOutput, Optional<List<String>> expectedsOpt,
			List<String> cleanedActuals) {
		return toComplete(actualOutput, expectedsOpt, cleanedActuals, (list, index) -> {
			return list.get(index) + "\n";
		});
	}

	public static String toCompleteFromListOfStrings(String actualOutput, List<String> expecteds,
			List<String> cleanedActuals) {
		return toCompleteFromListOfStrings(actualOutput, Optional.of(expecteds), cleanedActuals);
	}

	public static <T> String toLine(String actualOutput, Optional<List<T>> expectedsOpt,
			List<T> cleanedActuals, int lineIndex, BiFunction<List<T>, Integer, String> toTextFunction) {
		StringBuilder sb = new StringBuilder();
		if (expectedsOpt.isPresent()) {
			sb.append("\n=== expected line[").append(lineIndex).append("] (counting from 0) ===\n");
			sb.append(toTextFunction.apply(expectedsOpt.get(), lineIndex));
		}
		sb.append("\n=== actual (cleaned) line[").append(lineIndex).append("] (counting from 0) ===\n");
		sb.append(toTextFunction.apply(cleanedActuals, lineIndex));
		return sb.toString();
	}

	public static <T> String toLine(String actualOutput, List<T> expecteds,
			List<T> cleanedActuals, int lineIndex, BiFunction<List<T>, Integer, String> toTextFunction) {
		return toLine(actualOutput, Optional.of(expecteds), cleanedActuals, lineIndex, toTextFunction);
	}

	public static String toLineFromListOfStrings(String actualOutput, Optional<List<String>> expectedsOpt,
			List<String> cleanedActuals, int lineIndex) {
		return toLine(actualOutput, expectedsOpt, cleanedActuals, lineIndex, (list, index) -> {
			return list.get(index) + "\n";
		});
	}

	public static String toLineFromListOfStrings(String actualOutput, List<String> expecteds,
			List<String> cleanedActuals, int lineIndex) {
		return toLineFromListOfStrings(actualOutput, Optional.of(expecteds), cleanedActuals, lineIndex);
	}
}
