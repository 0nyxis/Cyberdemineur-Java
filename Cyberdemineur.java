public class Cyberdemineur
{
	Metier metier;
	Ihm ihm;
	public Cyberdemineur()
	{
		this.metier=new Metier(this,0);
		this.ihm=new Ihm (this);
	}
	public static void main(String[] args)
	{
		new Cyberdemineur();
	}
}