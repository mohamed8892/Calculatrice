package Modele;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

// Le mod�le re�oit toute les valeurs et fait tout les calculs
// il n'int�ragit pas avec la vue
public class CalculatriceModele {

    // variables qui permettent d'obtenir la valeur de la somme des calculs
    // entrez dans la vue
    private int sommeAddition, sommeSoustraction;

    // m�thodes d'addition et de soustraction
    public void addition(int premierNombre, int deuxiemeNombre) {

        sommeAddition = premierNombre + deuxiemeNombre;
    }

    public void soustraction(int premierNombre, int deuxiemeNombre) {

        sommeSoustraction = premierNombre - deuxiemeNombre;
    }

    // m�thode qui va fermer le programme au bout de 5s
    public static void fermetureProgramme() {

        Timer fermetureApresResultat = new Timer();
        fermetureApresResultat.schedule(new TimerTask() {

            public void run() {

                System.exit(0);
            }

        }, 10000 // les milisecondes du d�lais

        );
    }

    public void pauseProgramme() {

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    // getter des sommes des r�sultats 
    public int getSommeAddition() {

        return sommeAddition;
    }

    public int getSommeSoustraction() {

        return sommeSoustraction;
    }
}
