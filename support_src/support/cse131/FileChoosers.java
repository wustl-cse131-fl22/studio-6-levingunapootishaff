package support.cse131;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FileChoosers {
	private static File chooseFileFromFileChooser(File directory) {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(directory);
		fc.showOpenDialog(null);
		return fc.getSelectedFile();
	}

	public static File chooseFile(String[] argsFromMain, File directory) {
		File file = null;
		if (argsFromMain.length > 0) {
			file = new File(argsFromMain[0]);
			if (file.exists()) {
				// pass
			} else {
				file = new File(directory, argsFromMain[0]);
				if (file.exists()) {
					// pass
				} else {
					file = null;
				}
			}
		}
		if (file == null) {
			if (SwingUtilities.isEventDispatchThread()) {
				file = chooseFileFromFileChooser(directory);
			} else {
				File[] atFile = { null };
				try {
					SwingUtilities.invokeAndWait(() -> {
						atFile[0] = chooseFileFromFileChooser(directory);
					});
					file = atFile[0];
				} catch (InterruptedException | InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return file;
	}
}
