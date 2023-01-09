import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ihm extends JFrame implements ActionListener
{
	public static final int DELAI_CHRONO = 1000;
	Case[] grilleIHM;
	JPanel grilleCase;
	JPanel enJeu, uiInfo;
	Metier metier;
	BorderLayout bdl;
	JLabel  lblViesRestantes, lblBombesRestantes, lblTemps;
	Timer chrono;
	int tempsEcoule;

	public Ihm(Cyberdemineur cd)
	{
		this.metier=cd.metier;
		ImageIcon logo = new ImageIcon("Ressource\\logo_cyberdemineur.png");
		this.setIconImage(logo.getImage());

		this.setTitle("Cyberdémineur");
		this.setSize(1000,500);
		this.setLocation(500,100);
		this.setLayout(new BorderLayout());

		this.enJeu = new JPanel();
		this.enJeu.setLayout(new BorderLayout());
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

		/*/////////////////////////////////////////////////////////////////////////////////////////////
		//Ajout du panel qui affiche le temps passé, le nombre de vie restante et le nombre de bombes//
		/////////////////////////////////////////////////////////////////////////////////////////////*/

		this.uiInfo = new JPanel();
		this.bdl = new BorderLayout();
		this.bdl.setHgap(10);
		this.uiInfo.setLayout(this.bdl);

		//Ajout de la vie
		this.lblViesRestantes = new JLabel ("Vies restantes : "+this.metier.vieRestante, JLabel.LEFT);

		//Ajout du nombre de bombes restantes
		this.lblBombesRestantes = new JLabel ( "Bombes à trouver : " + (this.metier.diffChoisis[2]-this.metier.bombePosee),JLabel.RIGHT);

		//Ajout du timer
		this.tempsEcoule=0;
		this.lblTemps = new JLabel("Temps écoulé : " + this.tempsEcoule, JLabel.CENTER);
		this.chrono = new Timer(DELAI_CHRONO,this);

		//Ajout au panel ui
		this.uiInfo.add(this.lblViesRestantes  , BorderLayout.WEST);
		this.uiInfo.add(this.lblTemps          , BorderLayout.CENTER);
		this.uiInfo.add(this.lblBombesRestantes, BorderLayout.EAST);

		///////////////////////////////////////////////
		/* Ajout au panel général, puis dans la frame//
		/////////////////////////////////////////////*/

		this.enJeu.add(this.grilleCase, BorderLayout.CENTER);
		this.enJeu.add(this.uiInfo, BorderLayout.SOUTH);

		this.add(this.enJeu);

		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof Case)
			((Case)e.getSource()).majImage();
		if (e.getSource() == this.chrono)
		{
			this.tempsEcoule++;
			this.majIHM();
		}

	}

	public void clic(int ligne, int colonne)
	{
		if (this.grilleIHM[ligne*this.metier.diffChoisis[0]+colonne].getEtat()==Case.PAS_OUVERT)
			this.grilleIHM[ligne*this.metier.diffChoisis[0]+colonne].doClick();
	}

	public void majIHM()
	{
		this.lblViesRestantes.setText("Vies restantes : " + this.metier.vieRestante);
		this.lblBombesRestantes.setText( "Bombes à trouver : " + (this.metier.diffChoisis[2]-this.metier.bombePosee));
		this.lblTemps.setText("Temps écoulé : " + this.tempsEcoule);
	}

	public void startChrono()
	{
		this.chrono.start();
	}
}
