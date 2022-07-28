public class Metier 
{
	Cyberdemineur cd;
	Grille grilleConsole;

	int[] diffFacile    = {9 ,9 ,10};
	int[] diffNormal    = {12,12,25};
	int[] diffDifficile = {12,24,80};
	int[] diffChoisis;
	int bombeTrouvee, bombePosee;

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
	}

	public void ajouterBombeTrouvee()
	{
		this.bombeTrouvee++;
		this.bombePosee++;
	}

	public void retirerBombeTrouvee()
	{
		this.bombeTrouvee--;
		this.bombePosee--;
	}
	public void ajouterBombePosee()
	{
		this.bombePosee++;
	}

	public void retirerBombePosee()
	{
		this.bombePosee--;
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
		}
	}

}
