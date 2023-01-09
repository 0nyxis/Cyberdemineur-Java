import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;

public class WinScreen  extends JFrame
{
    BackgroundPanel panelPrincipal;
    JPanel panelBoutons, panelVide;
    JButton btnMenu;

    public WinScreen()
    {
        ImageIcon logo = new ImageIcon("Ressource\\logo_cyberdemineur.png");
        this.setIconImage(logo.getImage());

        this.setTitle("Cyberdémineur");

        this.setSize(1000,600);
        this.setLocation(300,150);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imgFond = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\bravo_fond.png")));
        this.panelPrincipal = new BackgroundPanel(imgFond.getImage());
        this.panelPrincipal.setBounds(0,0, 1000, 600);

        this.panelBoutons = new JPanel();

        this.panelPrincipal.add(this.panelBoutons);

        this.btnMenu = new JButton();
        this.btnMenu.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Ressource\\bravo_bouton_menu.png"))));
        this.btnMenu.setPreferredSize(new Dimension(500,60));

        this.panelBoutons.add(this.btnMenu);
        this.panelBoutons.setSize(new Dimension(2000,600));
        this.panelBoutons.setOpaque(false);
        this.panelPrincipal.add(this.panelBoutons);

        this.add(this.panelPrincipal, BorderLayout.SOUTH);
        this.setVisible(true);

    }
}
