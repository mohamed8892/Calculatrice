package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;public class CalculatriceBDD {
	
	private Connection cnx;
	private Statement stmt;
	private ResultSet rs;
	private String resultString;
	
	// Methodes
	
	// // Recherche et chargement du driver approprie a la BDD
	public void chargerDriver(String pilote) {
		
		// Chargement du Driver (pilote)
		try {
			Class.forName(pilote);
			System.out.println("Driver trouve!!!");
		}
		catch (ClassNotFoundException e) {

			System.out.println("Driver non trouve!!!");
			e.printStackTrace();
		}
	}
	
	// Etablissement de la connexion a la base de donnees
	public void connexionBdd(String localisationBdd, String bddName, String user, String password) {
		
		try {
			cnx = DriverManager.getConnection("jdbc:"+localisationBdd+bddName, user, password);
			System.out.println("Connexion a la BDD "+ bddName +" OK!!");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Probleme Connexion BDD "+ bddName + "  !!");

			e.printStackTrace();
		}
	}
	
	// Creation d'un objet Statement
	public void creerStatement() {
		try {
			stmt = cnx.createStatement();
		} 
		catch (SQLException e) {
			System.out.println("Probleme creation statement!!");
			e.printStackTrace();
		}
	}
	
	public void executeSelect(String requete) {
		try {
			rs = stmt.executeQuery(requete);
			
		} catch (SQLException e) {
			
			System.out.println("Probleme requete SELECT non execute !!");
			e.printStackTrace();
		}
	}
	
	public void executeUpdate(String requete) {
		try {
			stmt.executeUpdate(requete);
			System.out.println("Requete UPDATE executee !!");
		} catch (SQLException e) {
			
			System.out.println("Probleme requete UPDATE non executee !!");
			e.printStackTrace();
		}
	}
	
	public String recupererResultatsRequete() throws SQLException {		
		// Traitement de la reponse
		while (rs.next()) {
			resultString = ("Le meilleur score est: " + rs.getObject(1).toString() + " et il a ete obtenu par: "+ rs.getObject(2).toString()+" "+ rs.getObject(3).toString()+"!");	
		}
		return resultString;
	}
}