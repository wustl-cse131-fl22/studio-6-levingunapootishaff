package support.cse131;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class NotYetImplementedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotYetImplementedException() {
		super(Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	public NotYetImplementedException(String detail) {
		super(detail);
	}

}
