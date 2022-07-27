import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;

public class Case extends JButton
{
	private int lig;
	private int col;

	public Case(int ligne, int colonne)
	{
		super();
		this.lig=ligne;
		this.col=colonne;
		this.setIcon(new ImageIcon(this.getClass().getResource("Ressource\\case_vide.png")));
		this.setPreferredSize(new Dimension(60,60));

		//		this.setIcon(new ImageIcon(((new ImageIcon("Ressource\\case_vide.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
	}

	public int getLigne  () {return this.lig;}
	public int getColonne() {return this.col;}
}
