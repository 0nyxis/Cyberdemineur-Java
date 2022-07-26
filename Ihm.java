import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;


public class Ihm extends JFrame
{
	public Ihm()
	{
		ImageIcon logo = new ImageIcon("Ressource\\logo_cyberdemineur.png");
		this.setIconImage(logo.getImage());

		this.setTitle("Cyberdémineur");
		this.setSize(1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
