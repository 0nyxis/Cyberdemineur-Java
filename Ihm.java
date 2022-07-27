import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Ihm extends JFrame
{
	Case[] grilleIHM;
	JPanel grilleCase;

	public Ihm(Metier metier)
	{
		ImageIcon logo = new ImageIcon("Ressource\\logo_cyberdemineur.png");
		this.setIconImage(logo.getImage());

		this.setTitle("Cyberdémineur");
		this.setSize(1000,500);
		this.setLayout(new BorderLayout());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Ajout du panel qui affiche les boutons du jeu : les cases

		this.grilleCase = new JPanel();
		this.grilleCase.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx=metier.diffChoisis[0];
		gc.weighty=metier.diffChoisis[1];
		gc.fill= GridBagConstraints.BOTH;
					//metier.diffChoisis[0],metier.diffChoisis[1]

		this.grilleIHM = new Case[metier.diffChoisis[0]*metier.diffChoisis[1]];
		for (int i=0; i<metier.diffChoisis[0];i++)
		{
			for (int j=0; j<metier.diffChoisis[1];j++)
			{
				this.grilleIHM[i*j+i]= new Case(i,j);

				gc.gridx=i;
				gc.gridy=j;
				this.grilleCase.add(this.grilleIHM[i*j+i], gc);
			}
		}
		this.add(this.grilleCase, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
}
