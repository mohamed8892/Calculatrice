package Vue;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//la classe qui contient la publicite
public class CalculatricePub extends JFrame {

    private JLabel affichagePub = new JLabel();
    private JPanel fenetrePub = new JPanel();
  //JPanel pane = new JPanel();
   //JLabel image = new JLabel( new ImageIcon( "mon_image.jpg"));
    public CalculatricePub() {
            
        // param�trage de l'ihm
        this.setTitle("PUBLICITE");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full display
        fenetrePub.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

        // ajout des objets graphiques au jpanel
        fenetrePub.add(affichagePub);
        this.add(fenetrePub);

        affichagePub.setIcon(new ImageIcon("/home/lilicenco/NetBeansProjects/CalculatriceV1/src/Img/apple-iphonejpg.jpg" ));

    }
}
