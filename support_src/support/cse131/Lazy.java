package support.cse131;

import java.util.function.Supplier;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public final class Lazy<T> {
	public Lazy(Supplier<T> initializer) {
		this.initializer = initializer;
	}

	public T get() {
		T result = this.value;
		if (result != null) {
			// pass
		} else {
			synchronized (this) {
				result = this.value;
				if (result != null) {
					// pass
				} else {
					this.value = result = this.initializer.get();
				}
			}
		}
		return result;
	}

	private volatile T value;
	private final Supplier<T> initializer;
}
