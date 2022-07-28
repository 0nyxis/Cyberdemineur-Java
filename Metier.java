public class Metier 
{
	Grille grilleConsole;

	int[] diffFacile    = {9 ,9 ,10};
	int[] diffNormal    = {12,12,25};
	int[] diffDifficile = {12,24,20};
	int[] diffChoisis;

	public Metier(int difficulte)
	{
		switch (difficulte)
		{
			case 0 -> this.diffChoisis = this.diffFacile   ;
			case 1 -> this.diffChoisis = this.diffNormal   ;
			case 2 -> this.diffChoisis = this.diffDifficile;
		}

		this.grilleConsole=new Grille(this.diffChoisis[0],this.diffChoisis[1],this.diffChoisis[2]);
		System.out.println(this.grilleConsole);

	}

	public Grille getGrilleConsole()
	{
		return this.grilleConsole;
	}

}
