import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Case extends JButton
{
	private int lig;
	private int col;

	public Case(int ligne, int colonne)
	{
		super();
		this.lig=ligne;
		this.col=colonne;
		this.setIcon(new ImageIcon(this.getClass().getResource("Ressource\\case_cachee.png")));
	}

	public int getLigne  () {return this.lig;}
	public int getColonne() {return this.col;}
}
