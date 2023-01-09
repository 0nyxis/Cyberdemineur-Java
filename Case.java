import javax.swing.*;
import java.awt.Dimension;
import java.util.Objects;

public class Case extends JButton
{
	public static final int PAS_OUVERT = 0;
	public static final int OUVERT     = 1;
	public static final int DRAPEAU    = 2;

	private Metier met;
	private Cyberdemineur cd;

	private final int lig;
	private final int col;

	private int etat;

	public Case(Cyberdemineur cd, int ligne, int colonne)
	{
		super();
		this.cd=cd;
		this.met=cd.metier;

		this.lig=ligne;
		this.col=colonne;
		this.etat=PAS_OUVERT;

		this.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_cachee.png"))));
		this.setPreferredSize(new Dimension(60,60));

		//		this.setIcon(new ImageIcon(((new ImageIcon("Ressource\\case_vide.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
	}

	public int getLigne  () {return this.lig;}
	public int getColonne() {return this.col;}

	@Override
	public Icon getIcon() {return super.getIcon();}

	public int getEtat() {return etat;}

	public void majImage()
		{
			if (!(this.met.getPremierClic()))
			{
				Grille grilleConsole = this.met.getGrilleConsole();
				int valeurCase = grilleConsole.getValeurCase(this.getColonne(), this.getLigne());
				if (valeurCase != 0)
				{
					this.met.recreerGrille(this.cd,this.met.diffChoisis);
					this.majImage();
				}
				else
				{
					this.met.setPremierClic();
					this.cd.ihm.startChrono();
					this.majImage();
				}
			}
			else
			{
				Grille grilleConsole = this.met.getGrilleConsole();
				if (this.etat != DRAPEAU) {
					int valeurCase = grilleConsole.getValeurCase(this.getColonne(), this.getLigne());
					if (valeurCase == 0) {
						this.setEnabled(false);
						this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_vide.png"))));
						this.etat = OUVERT;
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++) {
								if (this.getLigne() + i - 1 >= 0 && this.getColonne() + j - 1 >= 0
										&& this.getLigne() + i - 1 < this.met.diffChoisis[1]
										&& this.getColonne() + j - 1 < this.met.diffChoisis[0])
									this.cd.ihm.clic(this.getLigne() + i - 1, this.getColonne() + j - 1);
							}
						}
						this.met.verifierFin();
						return;
					}
					this.setEnabled(false);
					if (valeurCase == 9) {
						this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_bombe.png"))));
						this.met.ajouterBombeTrouvee();
						this.met.viePerdu();
					} else {
						this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case" + valeurCase + ".png"))));
					}
					this.etat = OUVERT;
					this.met.verifierFin();
					return;
				}
			}
	}

	public void majDrapeau()		// Permet d'ajouter un drapeau en faisant un clic droit
	{
		int valeurCase=this.met.getGrilleConsole().getValeurCase(this.getColonne(), this.getLigne());
		if (this.etat ==DRAPEAU)		// S'il s'agit déjà d'un drapeau, remet la case en état "voilé"
		{
			this.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_cachee.png" ))));
			this.etat=PAS_OUVERT;
			if (valeurCase==9)
			{
				this.met.retirerBombeTrouvee();
			}
			else
			{
				this.met.retirerBombePosee();
			}
			this.met.verifierFin();
		}
		else
		{
			this.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_drapeau.png"))));
			this.etat=DRAPEAU;
			if (valeurCase==9)
			{
				this.met.ajouterBombeTrouvee();
			}
			else
			{
				this.met.ajouterBombePosee();

			}
			this.met.verifierFin();
		}
	}
}
