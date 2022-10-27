package studio6;

import java.util.Optional;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;
import studio6.circles.CirclesUponCirclesImages;
import support.cse131.DialogBoxes;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CirclesDemoApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			double bound = 5.0;
			StdDraw.setXscale(-bound, bound);
			StdDraw.setYscale(-bound, bound);
			StdDraw.enableDoubleBuffering();
			String title = CirclesDemoApp.class.getSimpleName();
			final double radius = 3.1;
			double radiusThreshold = 3.0;
			int n = 0;
			while (true) {
				StdDraw.clear();
				RecursiveMethods.circlesUponCircles(0.0, 0.0, radius, radiusThreshold);
				StdDraw.show();
				Object[] options = { "Continue", "Exit" };

				StringBuilder sb = new StringBuilder();
				sb.append("<html>");
				sb.append(String.format("Methods.circlesUponCircles(0.0, 0.0, %s, %s)", radius, radiusThreshold));
				sb.append("<br/>");
				sb.append("<br/>");
				Optional<Icon> iconOpt = CirclesUponCirclesImages.getIcon(n);
				Icon icon;
				sb.append("<center>");
				if (iconOpt.isPresent()) {
					sb.append("VVV expected image VVV");
					icon = iconOpt.get();
				} else {
					sb.append("expected image not available");
					icon = null;
				}
				sb.append("</center>");
				sb.append("</html>");
				JLabel label = new JLabel(sb.toString(), icon, SwingConstants.CENTER);
				label.setFont(label.getFont().deriveFont(18.0f));
				label.setVerticalTextPosition(JLabel.TOP);
				label.setHorizontalTextPosition(JLabel.CENTER);

				if (DialogBoxes.askUser(label, title, JOptionPane.QUESTION_MESSAGE, options)) {
					// pass
				} else {
					break;
				}
				radiusThreshold /= 3.0;
				++n;
			}
			System.exit(0);
		});
	}
}
