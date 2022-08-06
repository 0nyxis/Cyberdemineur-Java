public class Metier 
{
	public static final boolean NON_FAIT = false;
	public static final boolean FAIT = true;
	Cyberdemineur cd;
	Grille grilleConsole;

	int[] diffFacile    = {9 ,9 ,10};
	int[] diffNormal    = {12,12,25};
	int[] diffDifficile = {12,24,80};
	int[] diffChoisis;
	int bombeTrouvee, bombePosee, vieRestante;
	private boolean premierClic;

	public Metier(Cyberdemineur cd, int difficulte)
	{
		this.cd=cd;
		switch (difficulte)
		{
			case 0 -> this.diffChoisis = this.diffFacile   ;
			case 1 -> this.diffChoisis = this.diffNormal   ;
			case 2 -> this.diffChoisis = this.diffDifficile;
		}

		this.grilleConsole=new Grille(this.diffChoisis[0],this.diffChoisis[1],this.diffChoisis[2]);
		System.out.println(this.grilleConsole);

		this.bombeTrouvee=0;
		this.bombePosee  =0;
		this.vieRestante =3;
		this.premierClic=NON_FAIT;
	}

	public void ajouterBombeTrouvee()
	{
		this.bombeTrouvee++;
		this.bombePosee++;
		this.cd.ihm.majIHM();

	}

	public void retirerBombeTrouvee()
	{
		this.bombeTrouvee--;
		this.bombePosee--;
		this.cd.ihm.majIHM();

	}
	public void ajouterBombePosee()
	{
		this.bombePosee++;
		this.cd.ihm.majIHM();

	}

	public void retirerBombePosee()
	{
		this.bombePosee--;
		this.cd.ihm.majIHM();

	}

	public void viePerdu()
	{
		this.vieRestante--;
		this.cd.ihm.majIHM();
	}
	public Grille getGrilleConsole()
	{
		return this.grilleConsole;
	}

	public void verifierFin()
	{
		if (this.bombeTrouvee==this.diffChoisis[2])
		{
			this.cd.ihm.dispose();
			System.out.println("Gagné");
		}
		if (this.vieRestante==0)
		{
			this.cd.ihm.dispose();
			System.out.println("Perdu");
		}
	}

	public void recreerGrille(Cyberdemineur cd, int[] diffChoisis)
	{
		this.cd=cd;
		this.diffChoisis = diffChoisis;

		this.grilleConsole=new Grille(this.diffChoisis[0],this.diffChoisis[1],this.diffChoisis[2]);
		System.out.println(this.grilleConsole);

		this.bombeTrouvee=0;
		this.bombePosee  =0;
		this.vieRestante =3;
		this.premierClic =NON_FAIT;
	}

	public boolean getPremierClic() {return this.premierClic;}

	public void setPremierClic() {this.premierClic=FAIT;}

}
