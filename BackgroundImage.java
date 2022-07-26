import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BackgroundImage implements ActionListener
{
  public static void main(String args[]) 
  {

    Dimension taille = Toolkit.getDefaultToolkit().getScreenSize();
    int largeur = (int)taille.getWidth();
    int hauteur = (int)taille.getHeight();

    JFrame frame = new JFrame("Afficher une image en arrière-plan");
    final ImageIcon icon = new ImageIcon("Ressource\\fond1.png");
    JPanel text = new JPanel()
    {
      Image img = icon.getImage();
      // initialiseur d'instance
      {setOpaque(false);}
      public void paintComponent(Graphics graphics) 
      {
        graphics.drawImage(img,0, 0, largeur,hauteur, this);
        super.paintComponent(graphics);
      }
    };
    JButton bouton = new JButton(new ImageIcon("Ressource\\case1.png"));
    bouton.setBorder(null);
    bouton.addActionListener(this);
    text.add(bouton);

    JScrollPane pane = new JScrollPane(text);
    Container content = frame.getContentPane();
    content.add(pane, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(3);
    frame.setSize(400, 300);
    frame.setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent arg0) 
  {
    System.out.println("ça marche !");
  }

}