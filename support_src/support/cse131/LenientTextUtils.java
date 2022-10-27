package support.cse131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Dennis Cosgrove
 */
public class LenientTextUtils {
	public static enum WhitespacePolicy {
		PRESERVE(true), CLEAN(false);

		private final boolean isPreserve;

		private WhitespacePolicy(boolean isPreserve) {
			this.isPreserve = isPreserve;
		}

		public boolean isPreserve() {
			return isPreserve;
		}
	}

	public static List<String> toCleanedLines(String text, WhitespacePolicy beginningPolicy,
			WhitespacePolicy endingPolicy, WhitespacePolicy emptyPolicy) {
		String[] lines = text.split("\n");
		return Arrays.stream(lines).map((String line) -> {
			if (beginningPolicy.isPreserve()) {
				if (endingPolicy.isPreserve) {
					return line;
				} else {
					// remove trailing whitespace
					return line.replaceFirst("\\s+$", "");
				}
			} else {
				if (endingPolicy.isPreserve) {
					// remove leading whitespace
					return line.replaceFirst("^\\s+", "");
				} else {
					return line.trim();
				}
			}
		}).filter((String line) -> {
			// remove empty lines
			return endingPolicy.isPreserve() || line.length() > 0;
		}).collect(Collectors.toList());
	}

	public static List<String> toTrimmedNonemptyLines(String text) {
		return toCleanedLines(text, WhitespacePolicy.CLEAN, WhitespacePolicy.CLEAN, WhitespacePolicy.CLEAN);
	}

	public static List<List<String>> toLinesOfTokenLists(String text) {
		List<String> lines = toTrimmedNonemptyLines(text);
		return lines.stream().map((String line) -> {
			return Arrays.asList(line.split("\\s+"));
		}).collect(Collectors.toList());
	}

	public static List<String> toLinesOfSpaceSeparatedTokens(String text) {
		List<List<String>> linesOfWords = toLinesOfTokenLists(text);
		return linesOfWords.stream().map((List<String> tokens) -> {
			String separator = "";
			StringBuilder sb = new StringBuilder();
			for (String token : tokens) {
				sb.append(separator).append(token);
				separator = " ";
			}
			return sb.toString();
		}).collect(Collectors.toList());
	}

	public static String fromTokens(List<String> tokens, String separator) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (String token : tokens) {
			sb.append(token);
			++index;
			if (index < tokens.size()) {
				sb.append(separator);
			}
		}
		return sb.toString();
	}

	public static String fromTokens(List<String> tokens) {
		return fromTokens(tokens, " ");
	}

	public static String fromlnTokens(List<String> tokens, String separator) {
		StringBuilder sb = new StringBuilder();
		sb.append(fromTokens(tokens, separator));
		sb.append("\n");
		return sb.toString();
	}

	public static String fromlnTokens(List<String> tokens) {
		return fromlnTokens(tokens, " ");
	}

	public static String fromlnTokensLists(List<List<String>> tokensLists) {
		StringBuilder sb = new StringBuilder();
		for (List<String> tokens : tokensLists) {
			sb.append(fromlnTokens(tokens));
		}
		return sb.toString();
	}

	private static <N extends Number> List<N> toNumbers(List<String> tokens, Function<String, N> parseNumberFunction) {
		List<N> result = new ArrayList<>(tokens.size());
		for (String token : tokens) {
			result.add(parseNumberFunction.apply(token));
		}
		return result;
	}

	public static List<Integer> toIntegers(List<String> tokens) {
		return toNumbers(tokens, (s) -> Integer.parseInt(s));
	}

	public static List<Double> toDoubles(List<String> tokens) {
		return toNumbers(tokens, (s) -> Double.parseDouble(s));
	}

	public static List<Integer> toIntegers(List<String> tokens, int fromIndex, int toIndex) {
		return toIntegers(tokens.subList(fromIndex, toIndex));
	}

	public static List<Double> toDoubles(List<String> tokens, int fromIndex, int toIndex) {
		return toDoubles(tokens.subList(fromIndex, toIndex));
	}

	public static List<Integer> toIntegers(List<String> tokens, int fromIndex) {
		return toIntegers(tokens.subList(fromIndex, tokens.size()));
	}

	public static List<Double> toDoubles(List<String> tokens, int fromIndex) {
		return toDoubles(tokens.subList(fromIndex, tokens.size()));
	}
}
