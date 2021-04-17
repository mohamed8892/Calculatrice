package Modele;

import java.util.concurrent.TimeUnit;

public class CalculatriceModele {

	// variables qui permettent d'obtenir la valeur de la somme des calculs
	// entrez dans la vue

	private int sommeAddition, sommeSoustraction;

	// m�thodes d'addition et de soustraction
	
	public void addition(int premierNombre, int deuxiemeNombre){
						
		 sommeAddition = premierNombre + deuxiemeNombre;
		
		}
	
	public void soustraction(int premierNombre, int deuxiemeNombre) {
		
		sommeSoustraction = premierNombre - deuxiemeNombre;
	}
	
	// getter des sommes des resultats 
	
	public int getSommeAddition() {
		
		return sommeAddition;
	}
	
	public int getSommeSoustraction() {
		
		return sommeSoustraction;
	}
	
	public void pauseProgramme(int secondes) {

		try {
			TimeUnit.SECONDS.sleep(secondes);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
