import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Image;

public class Test extends JFrame
{
	public Test()
	{
		Image imgFond = Toolkit.getDefaultToolkit().getImage("Ressource\\fond4.png");
		this.add(new BackgroundPanel(imgFond));
		this.setSize(1000,500);
		this.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Test();
	}
}
