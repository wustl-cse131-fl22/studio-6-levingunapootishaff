package studio6.circles;

import java.awt.Image;
import java.net.URL;
import java.util.Optional;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CirclesUponCirclesImages {
	public static Optional<Icon> getIcon(int n) {
		URL url = CirclesUponCirclesImages.class.getResource(String.format("images/circles_upon_circles_%d.png", n));
		if (url != null) {
			ImageIcon imageIcon = new ImageIcon(url);
			Image scaledImage = imageIcon.getImage().getScaledInstance(512, 512, Image.SCALE_SMOOTH);
			return Optional.of(new ImageIcon(scaledImage));
		} else {
			return Optional.empty();
		}
	}
}
