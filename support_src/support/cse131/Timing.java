package support.cse131;

import java.util.Optional;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Timing {
	private static Optional<Long> t0 = Optional.empty();

	public static double getCurrentTimeInSeconds() {
		return getCurrentTimeInMilliseconds() * 0.001;
	}

	public static int getCurrentTimeInMilliseconds() {
		if (t0.isPresent()) {
			long millisDelta = System.currentTimeMillis() - t0.get();
			return (int) millisDelta;
		} else {
			t0 = Optional.of(System.currentTimeMillis());
			return 0;
		}
	}
}
