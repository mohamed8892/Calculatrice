package Vue;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;

//la seule fonctionnalite de la vue est d'afficher 
//ce que l'utilisateur va voir, aucun calculs ne sera fait
public class CalculatriceVue extends JFrame {

    private JComboBox<Integer> premierNombre = new JComboBox<Integer>();
    private JComboBox<String> operateurs = new JComboBox<String>();
    private JComboBox<Integer> deuxiemeNombre = new JComboBox<Integer>();
    private JLabel labelEgal = new JLabel(" = ");
    private JComboBox<Integer> resultatPropose = new JComboBox<Integer>();
    private JButton bouttonVerification = new JButton("Compter");
    private JLabel affichageBonMauvais = new JLabel(" ");
    private JLabel affichageResultat = new JLabel();

    //constructeur de la classe CalculatriceVue
    public CalculatriceVue() {

        // ihm parametres
        JPanel fenetreCalcul = new JPanel();

        this.setTitle("Calculatrice Version 2.0");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Affectation des valeurs des listes de JCombobox
        Integer[] listeNombre = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] listeOperateur = new String[]{"+", "-"};

        // affectation des JCombobox qui poss�de une liste a une variable 
        // pour pouvoir l'ajouter � la fenetreCalcul 
        premierNombre = new JComboBox<Integer>(listeNombre);
        operateurs = new JComboBox<String>(listeOperateur);
        deuxiemeNombre = new JComboBox<Integer>(listeNombre);
        resultatPropose = new JComboBox<Integer>(listeNombre);

        // ajout des objets graphiques de l'ihm calculatrice dans le conteneur
        bouttonVerification.setBackground(new Color(59, 89, 182));
        fenetreCalcul.setBackground(Color.gray);
        fenetreCalcul.add(premierNombre);
        fenetreCalcul.add(operateurs);
        fenetreCalcul.add(deuxiemeNombre);
        fenetreCalcul.add(labelEgal);
        fenetreCalcul.add(resultatPropose);
        fenetreCalcul.add(bouttonVerification);
        fenetreCalcul.add(affichageBonMauvais);
        fenetreCalcul.add(affichageResultat);

        this.add(fenetreCalcul);
    }

    // les getter retourne la valeur de l'index selectionne dans le JCombobox
    public int getPremierNombre() {

        return (int) premierNombre.getSelectedItem();
    }

    public int getDeuxiemeNombre() {

        return (int) deuxiemeNombre.getSelectedItem();
    }

    public String getOperateurs() {

        return (String) operateurs.getSelectedItem();
    }

    public int getResultatPropose() {

        return (int) resultatPropose.getSelectedItem();
    }

    // affiche le resultat du calcul dans le label Resultat
    public void setAffichageBonMauvais(String bonOuMauvais) {

        affichageBonMauvais.setText(bonOuMauvais);
    }

    public void setAffichageResultat(int resultatOperation) {

        affichageResultat.setText(Integer.toString(resultatOperation));
    }

    public void setAffichageResultatNettoyage() {

        affichageResultat.setText(" ");
    }

    // m�thode qui ajoute une action de type event a un boutton 
    public void recepteurBouttonVerification(ActionListener recepteurBoutonVerif) {

        bouttonVerification.addActionListener(recepteurBoutonVerif);
    }

    // Ouvre une fenetre qui va alerter le msg d'erreur
    public void affichageMsgErreur(String messageErreur) {

        JOptionPane.showMessageDialog(this, messageErreur);
    }
}
