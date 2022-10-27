package support.cse131;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

/**
 * @author Dennis Cosgrove
 */
public class OutputUtils {
	public static String capture(Runnable runnable) throws IOException {
		PrintStream preserved = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		try {
			runnable.run();
			ps.flush();
			ps.close();
			byte[] data = baos.toByteArray();
			return new String(data, Charset.defaultCharset());
		} finally {
			System.setOut(preserved);
		}
	}
}
