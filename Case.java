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
	private int lig;
	private int col;
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
		Grille grilleConsole = this.met.getGrilleConsole();
		if(this.etat!=DRAPEAU)
		{
			switch (grilleConsole.getValeurCase(this.getColonne(), this.getLigne())) {
				case 0 -> {
					System.out.println("Case ouverte : " + (this.getLigne()) + "|" + (this.getColonne()));
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_vide.png"))));
					this.etat = OUVERT;
					System.out.println("Case à ouvrir : " + (this.getLigne() - 1) + "|" + (this.getColonne() - 1));
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (this.getLigne() + i - 1 >= 0 && this.getColonne() + j - 1 >= 0
									&& this.getLigne() + i - 1 < this.met.diffChoisis[1]
									&& this.getColonne() + j - 1 < this.met.diffChoisis[0])
								this.cd.ihm.clic(this.getLigne() + i - 1, this.getColonne() + j - 1);
						}
					}
				}
				case 1 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case1.png"))));
					this.etat = OUVERT;
				}
				case 2 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case2.png"))));
					this.etat = OUVERT;
				}
				case 3 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case3.png"))));
					this.etat = OUVERT;
				}
				case 4 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case4.png"))));
					this.etat = OUVERT;
				}
				case 5 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case5.png"))));
					this.etat = OUVERT;
				}
				case 6 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case6.png"))));
					this.etat = OUVERT;
				}
				case 7 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case7.png"))));
					this.etat = OUVERT;
				}
				case 8 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case8.png"))));
					this.etat = OUVERT;
				}
				case 9 -> {
					this.setEnabled(false);
					this.setDisabledIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_bombe.png"))));
					this.etat = OUVERT;
				}
				default -> System.out.println("Erreur");
			}
		}
	}

	public void majDrapeau()		// Permet d'ajouter un drapeau en faisant un clic droit
	{
		if (this.etat ==DRAPEAU)		// S'il s'agit déjà d'un drapeau, remet la case en état "voilé"
		{
			this.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_cachee.png" ))));
			this.etat=PAS_OUVERT;
		}
		else
		{
			this.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\case_drapeau.png"))));
			this.etat=DRAPEAU;
		}
	}
}
