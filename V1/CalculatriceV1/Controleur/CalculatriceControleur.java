package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CalculatriceModele;
import Vue.CalculatricePub;
import Vue.CalculatriceVue;

//le contrôleur c'est un lien entre la vue et le modèle
public class CalculatriceControleur {

    // attributs
    private CalculatriceVue laVue;
    private CalculatriceModele leModele;
    private CalculatricePub laPub;

    // constructeur qui prend en param�tre une instance de la classe Vue et du Modele
    public CalculatriceControleur(CalculatriceVue laVue, CalculatriceModele leModele, CalculatricePub laPub) {

        this.laVue = laVue;
        this.leModele = leModele;
        this.laPub = laPub;

        // methode qui va bloquer le programme pendant 10s pour la publicit� 
        this.leModele.pauseProgramme();

        // je rend visible la calculatrice et je fais disparaitre la pub 
        this.laVue.setVisible(true);
        this.laPub.setVisible(false);

        this.laVue.ecouteurBoutonVerification(new RecepteurBoutonVerif());
    }

    class RecepteurBoutonVerif implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // declaration et initialisation des variables qui vont etre 
            // utilises en parametre de fonction
            int premierNombre = laVue.getPremierNombre();
            int deuxiemeNombre = laVue.getDeuxiemeNombre();

            //condition qui va faire une addition ou une soustraction 
            //en fonction de l'operateur selectionn�
            if (laVue.getOperateurs() == "+") {

                leModele.addition(premierNombre, deuxiemeNombre);

                //condition qui va v�rifier si le resultat de l'addition  
                // est egal au resultat propose par l'eleve et afficher Bon ou Mauvais
                if (leModele.getSommeAddition() == laVue.getResultatPropose()) {

                    int resultat = leModele.getSommeAddition();
                    laVue.setAffichageBonMauvais(" Le calcul est bon : ", resultat);

                    //  le programme se ferme 10s apr�s l'affichage 
                    CalculatriceModele.fermetureProgramme();

                } else {

                    // condition pour emp�cher d'afficher une r�ponse si la somme est > 10
                    if (leModele.getSommeAddition() <= 10) {

                        int resultat = leModele.getSommeAddition();
                        laVue.setAffichageBonMauvais(" Le calcul ne été pas correct! La bonne réponse est : ", resultat);

                        //  le programme se ferme 10s apr�s l'affichage 
                        CalculatriceModele.fermetureProgramme();
                    }
                }

            } else {

                leModele.soustraction(premierNombre, deuxiemeNombre);

                //condition qui va v�rifier si le r�sultat de la soustraction  
                // est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais
                if (leModele.getSommeSoustraction() == laVue.getResultatPropose() && leModele.getSommeSoustraction() >= 0) {

                    int resultat = leModele.getSommeSoustraction();
                    laVue.setAffichageBonMauvais("Le calcul est bon : ", resultat);

                    //  le programme se ferme 10s apr�s l'affichage 
                    CalculatriceModele.fermetureProgramme();

                } else {

                    // condition pour emp�cher d'afficher une r�ponse si la somme est < 0
                    if (leModele.getSommeSoustraction() >= 0) {

                        int resultat = leModele.getSommeSoustraction();
                        laVue.setAffichageBonMauvais("Le calcul n'est pas correct! La bonne réponse est : ", resultat);

                        //  le programme se ferme 10s apr�s l'affichage 
                        CalculatriceModele.fermetureProgramme();
                    }
                }
            }

            // condition qui va afficher un msg d'erreur si les r�sultats de l'op�ration sont > 10 ou < 0
            if (leModele.getSommeAddition() > 10 || leModele.getSommeSoustraction() < -0) {

                // Le résultat ne s'affichera pas s'il est supérieur à 10 ou inférieur à 0
                laVue.setAffichageBonMauvaisNettoyage();
                laVue.affichageMsgErreur("Votre résultat est supérieur à 10 ou inférieur à 0, sélectionnez un nombre de 0 à 10");
            }

        }
    }

}
