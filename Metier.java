public class Metier 
{
	Grille grilleConsole;
	Case[] grilleIHM;

	public Metier()
	{
		this.grilleConsole=new Grille(9,20,10);

		System.out.println(this.grilleConsole.toString());
	}

}
