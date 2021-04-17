package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Modele.CalculatriceModele;
import Vue.CalculatricePub;
import Vue.CalculatriceVue;

// le controleur fait le pont 
// entre la vue et le modele
public class CalculatriceControleur {

    private CalculatriceVue laVue;
    private CalculatriceModele leModele;
    private CalculatricePub laPub;
    private int conteneurErreur;

    public CalculatriceControleur(CalculatriceVue laVue, CalculatriceModele leModele, CalculatricePub laPub) {
        this.laVue = laVue;
        this.leModele = leModele;
        this.laPub = laPub;

        // m�thode qui va bloquer le programme pendant 5s pour la publicite
        this.leModele.pauseProgramme(5);

        // je rend visible la calculatrice et je fais disparaitre la pub 
        this.laVue.setVisible(true);
        this.laPub.setVisible(false);

        this.laVue.recepteurBouttonVerification(new RecepteurCalculatrice());

    }

    class RecepteurCalculatrice implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // d�claration et initialisation des variables qui vont �tre 
            // utilis�s en param�tre de fonction
            int premierNombre = laVue.getPremierNombre();
            int deuxiemeNombre = laVue.getDeuxiemeNombre();

            //condition qui va faire une addition ou une soustraction 
            //en fonction de l'op�rateur selectionn�
            if (laVue.getOperateurs() == "+") {

                leModele.addition(premierNombre, deuxiemeNombre);

                //condition qui va v�rifier si le r�sultat de l'addition  
                // est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais
                if (leModele.getSommeAddition() == laVue.getResultatPropose() && leModele.getSommeAddition() <= 10) {

                    laVue.setAffichageBonMauvais(" Le resultat choisit est BON! Felicitation!!");

                    // boite de dialogue qui affichera la pub pendant 5s si l'utilisteur ferme le programme
                    int choix = JOptionPane.showConfirmDialog(null,
                            "Voulez vous arreter ? ",
                            "Cliquez sur OUI pour arreter l'application", JOptionPane.YES_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
                    if (choix == JOptionPane.YES_OPTION) {

                        laPub.setVisible(true);
                        laVue.setVisible(false);
                        leModele.pauseProgramme(5);
                        System.exit(0);
                    }

                } else if (leModele.getSommeAddition() != laVue.getResultatPropose() && leModele.getSommeAddition() <= 10) {

                    laVue.setAffichageBonMauvais(" Le resultat choisit est MAUVAIS! Re-essaye!");
                    conteneurErreur = conteneurErreur + 1;
                    laVue.setAffichageResultatNettoyage();

                    if (conteneurErreur == 3) {

                        // reinitialisation du conteneur 
                        conteneurErreur = 0;
                        laVue.setAffichageBonMauvais(" Tu as echoue 3 fois! Le resultat etait: ");
                        laVue.setAffichageResultat(leModele.getSommeAddition());

                        // boite de dialogue qui affichera la pub pendant 5s si l'utilisteur ferme le programme
                        int choix = JOptionPane.showConfirmDialog(null,
                                "Voulez vous arreter ? ",
                                "Cliquez sur OUI pour arreter l'application", JOptionPane.YES_OPTION,
                                JOptionPane.INFORMATION_MESSAGE);
                        if (choix == JOptionPane.YES_OPTION) {

                            laPub.setVisible(true);
                            laVue.setVisible(false);
                            leModele.pauseProgramme(5);
                            System.exit(0);
                        }
                    }
                }

            } else {

                leModele.soustraction(premierNombre, deuxiemeNombre);

                //condition qui va v�rifier si le resultat de la soustraction  
                // est egal au resultat propose par l'eleve et afficher Bon ou Mauvais
                if (leModele.getSommeSoustraction() == laVue.getResultatPropose() && leModele.getSommeSoustraction() >= 0) {

                    laVue.setAffichageBonMauvais(" Le resultat choisit est BON! Felicitation!");

                    // boite de dialogue qui affichera la pub pendant 5s si l'utilisteur ferme le programme
                    int choix = JOptionPane.showConfirmDialog(null,
                            "Voulez vous arreter ? ",
                            "Cliquez sur YES pour arreter l'application", JOptionPane.YES_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
                    if (choix == JOptionPane.YES_OPTION) {

                        laPub.setVisible(true);
                        laVue.setVisible(false);
                        leModele.pauseProgramme(5);
                        System.exit(0);
                    }

                } else if (leModele.getSommeSoustraction() != laVue.getResultatPropose() && leModele.getSommeSoustraction() >= 0) {

                    laVue.setAffichageBonMauvais(" Le resultat choisit est MAUVAIS! Re-essaye!");

                    conteneurErreur = conteneurErreur + 1;
                    laVue.setAffichageResultatNettoyage();

                    if (conteneurErreur == 3) {
                        conteneurErreur = 0;
                        laVue.setAffichageBonMauvais(" Tu as echoue 3 fois! Le resultat etait: ");
                        laVue.setAffichageResultat(leModele.getSommeSoustraction());

                        // boite de dialogue qui affichera la pub pendant 5s si l'utilisteur ferme le programme
                        int choix = JOptionPane.showConfirmDialog(null,
                                "Voulez vous arreter ? ",
                                "Cliquez sur OUI pour arreter l'application", JOptionPane.YES_OPTION,
                                JOptionPane.INFORMATION_MESSAGE);
                        if (choix == JOptionPane.YES_OPTION) {

                            laPub.setVisible(true);
                            laVue.setVisible(false);
                            leModele.pauseProgramme(5);
                            System.exit(0);
                        }
                    }
                }
            }

            // condition qui va afficher un msg d'erreur si les resultats de l'operation sont > 10 ou < 0
            if (leModele.getSommeAddition() > 5 || leModele.getSommeSoustraction() < -0) {

                laVue.affichageMsgErreur("Le resultat ne doit pas depasser 10 ou descendre en dessous de 0! Choisis une autre operation!");
                laVue.setAffichageBonMauvais("Choisis une autre operation!!");
                laVue.setAffichageResultatNettoyage();
            }
        }
    }
}
