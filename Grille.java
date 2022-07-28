import java.util.Random;

public class Grille 
{
	private int lig, col, nb_bombes;
	private int[][][] grille;

	public Grille(int ligne, int colonne, int nb_Bombes)
	{
		if (nb_Bombes>ligne*colonne)			// Vérification uniquement de debug
			System.out.println("[ERREUR] TROP DE BOMBES");
		
		else
		{
			this.lig=ligne;
			this.col=colonne;
			this.nb_bombes=nb_Bombes;
		}

		// On génère une grille vide
		this.grille=new int[ligne][colonne][1];				

		// Ajout des bombes dans le tableau, de façon aléatoire
		int bombes_placees = 0;
		while (bombes_placees!=this.nb_bombes)
		{
			Random nb_aleatoire = new Random();
			int posY = nb_aleatoire.nextInt(0+this.lig);		// Ligne aléatoire
			int posX = nb_aleatoire.nextInt(0+this.col);		// Colonne aléatoire

			if (this.grille[posY][posX][0]<9)		// Vérifie que la case n'a pas déjà de bombes
			{
				this.grille[posY][posX][0]=9;
				bombes_placees++;
			}
		}

		/*-------------------------------------*/
		// Ajout des valeurs autour des bombes  /
		/*-------------------------------------*/
		
		// Intérieur
		for (int i=1;i<this.lig-1;i++)
		{
			for (int j=1;j<this.col-1;j++)
			{
				if (this.grille[i][j][0]>=9)
				{
					this.grille[ i ][j+1][0]+=1;
					this.grille[ i ][j-1][0]+=1;
					this.grille[i+1][ j ][0]+=1;
					this.grille[i-1][ j ][0]+=1;
					this.grille[i-1][j-1][0]+=1;
					this.grille[i+1][j+1][0]+=1;
					this.grille[i+1][j-1][0]+=1;
					this.grille[i-1][j+1][0]+=1;
				}
			}
		}

		// Côté haut
		for (int j=0;j<this.col;j++)
		{
			if (this.grille[0][j][0]>=9)
			{
				if (j==0)
				{
					this.grille[ 0 ][j+1][0]+=1;
					this.grille[0+1][ j ][0]+=1;
					this.grille[0+1][j+1][0]+=1;
				}
				else
				{	if (j==this.col-1)
					{
						this.grille[ 0 ][j-1][0]+=1;
						this.grille[0+1][ j ][0]+=1;
						this.grille[0+1][j-1][0]+=1;
					}
					else
					{
						this.grille[ 0 ][j+1][0]+=1;
						this.grille[ 0 ][j-1][0]+=1;
						this.grille[0+1][ j ][0]+=1;
						this.grille[0+1][j+1][0]+=1;
						this.grille[0+1][j-1][0]+=1;
					}
				}			
			}
		}

		// Côté bas
		for (int j=0;j<this.col;j++)
		{
			if (this.grille[this.lig-1][j][0]>=9)
			{
				if (j==0)
				{
					this.grille[this.lig-1][j+1][0]+=1;
					this.grille[this.lig-2][ j ][0]+=1;
					this.grille[this.lig-2][j+1][0]+=1;
				}
				else
				{	
					if (j==this.col-1)
					{
						this.grille[this.lig-1][j-1][0]+=1;
						this.grille[this.lig-2][ j ][0]+=1;
						this.grille[this.lig-2][j-1][0]+=1;
					}
					else
					{
						this.grille[this.lig-1][j+1][0]+=1;
						this.grille[this.lig-1][j-1][0]+=1;
						this.grille[this.lig-2][ j ][0]+=1;
						this.grille[this.lig-2][j-1][0]+=1;
						this.grille[this.lig-2][j+1][0]+=1;
					}
				}			
			}
		}

		// Côté gauche
		for (int i=1;i<this.lig-1;i++)
		{
			if (this.grille[i][0][0]>=9)
			{
				this.grille[ i ][0+1][0]+=1;
                this.grille[i+1][ 0 ][0]+=1;
                this.grille[i-1][ 0 ][0]+=1;
                this.grille[i+1][0+1][0]+=1;
                this.grille[i-1][0+1][0]+=1;
			}
		}

		// Côté droit
		for (int i=1;i<this.lig-1;i++)
		{
			if (this.grille[i][this.col-1][0]>=9)
			{
                this.grille[ i ][this.col-2][0]+=1;
                this.grille[i+1][this.col-1][0]+=1;
                this.grille[i-1][this.col-1][0]+=1;
                this.grille[i-1][this.col-2][0]+=1;
                this.grille[i+1][this.col-2][0]+=1;
			}
		}


		/* Transforme les bombes avec valeurs > 9 (cas où plusieurs bombes sont
		   à côté l'une de l'autre) en 9, facilite le fonctionnement et la 
		   compréhension du code
		*/ 
		for (int i=0;i<this.lig;i++)
		{
			for (int j=0;j<this.col;j++)
			{
				if (this.grille[i][j][0]>=9)
					this.grille[i][j][0]=9;
			}
		}
	}



	public String toString()
	{
		String resultat="";
		for (int i=0;i<this.lig;i++)
		{
			resultat+="+" + String.format("%"+(2*this.col) + "s","+").replace(" ", "-") + "\n";
			resultat+="|";
			for (int j=0;j<this.col;j++)
			{
				resultat+=this.grille[i][j][0] + "|";
			}
			resultat+="\n";
		}
		resultat+="+" + String.format("%"+(2*this.col) + "s","+").replace(" ", "-") + "\n";

		return resultat;
	}

	public int getValeurCase(int ligne, int colonne)
	{
		return this.grille[ligne][colonne][0];
	}
	


}
