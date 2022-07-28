import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ihm extends JFrame implements ActionListener
{
	Case[] grilleIHM;
	JPanel grilleCase;
	Metier metier;

	public Ihm(Cyberdemineur cd)
	{
		this.metier=cd.metier;
		ImageIcon logo = new ImageIcon("Ressource\\logo_cyberdemineur.png");
		this.setIconImage(logo.getImage());

		this.setTitle("Cyberdémineur");
		this.setSize(1000,500);
		this.setLayout(new BorderLayout());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Création d'un Mouse Listener
		MouseListener ml = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton()==3)
				{
					((Case)e.getSource()).majDrapeau();
				}
			}
			public void mousePressed  (MouseEvent e) {   }
			public void mouseReleased (MouseEvent e) {   }
			public void mouseEntered  (MouseEvent e) {   }
			public void mouseExited   (MouseEvent e) {   }
		};
		// Ajout du panel qui affiche les boutons du jeu : les cases

		this.grilleCase = new JPanel();
		this.grilleCase.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx=metier.diffChoisis[0];
		gc.weighty=metier.diffChoisis[1];
		gc.fill= GridBagConstraints.BOTH;

		this.grilleIHM = new Case[this.metier.diffChoisis[0]*this.metier.diffChoisis[1]];

		for (int i=0; i<this.metier.diffChoisis[1];i++)
		{
			for (int j=0; j<this.metier.diffChoisis[0];j++)
			{
				this.grilleIHM[i*this.metier.diffChoisis[0]+j]= new Case(cd,i,j);
				gc.gridx=i;
				gc.gridy=j;
				this.grilleCase.add(this.grilleIHM[i*this.metier.diffChoisis[0]+j], gc);

				this.grilleIHM[i*this.metier.diffChoisis[0]+j].addActionListener(this);
				this.grilleIHM[i*this.metier.diffChoisis[0]+j].addMouseListener(ml);
			}
		}
		this.add(this.grilleCase, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		((Case)e.getSource()).majImage();
	}

	public void clic(int ligne, int colonne)
	{
		System.out.println(ligne + "|" + colonne);
		if (this.grilleIHM[ligne*this.metier.diffChoisis[0]+colonne].getEtat()==Case.PAS_OUVERT)
			this.grilleIHM[ligne*this.metier.diffChoisis[0]+colonne].doClick();
	}
}
