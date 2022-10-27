package support.cse131;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DialogBoxes {
	public static boolean askUser(Object message) {
		return askUser(message, null);
	}

	public static boolean askUser(Object message, String title) {
		return askUser(message, title, JOptionPane.QUESTION_MESSAGE);
	}

	public static boolean askUser(Object message, String title, int messageType) {
		Object[] options = { "True", "False" };
		return askUser(message, title, messageType, options);
	}

	public static boolean askUser(Object message, String title, int messageType, Object[] options) {
		JComponent parent = null;
		int option = JOptionPane.showOptionDialog(parent, message, title,
				JOptionPane.YES_NO_OPTION, messageType, null, options, options[0]);
		return option == JOptionPane.YES_OPTION;
	}
}
