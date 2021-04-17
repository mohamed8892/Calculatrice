package Vue;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modele.CalculatriceModele;
import javax.swing.ImageIcon;

// classe pour affiche la publicite
public class CalculatricePub extends JFrame {

    private JLabel affichagePub = new JLabel("");
    private JPanel fenetrePub = new JPanel();

    public CalculatricePub() {

        // parametre de l'ihm
        this.setTitle("PUBLICITE");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // plein ecran par defaut
        fenetrePub.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

        // ajout des objets graphiques au jpanel
        fenetrePub.add(affichagePub);
        this.add(fenetrePub);
        affichagePub.setIcon(new ImageIcon("/home/lilicenco/NetBeansProjects/CalculatriceV2/src/Img/pubv2.jpg"));
    }
}
