package Vue;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveEleve extends JFrame {
	
	private JPanel panelEnregistrement = new JPanel();
	private JLabel labelNom = new JLabel("Inserez votre nom: ");
	private JTextField textNom = new JTextField(10);
	private JLabel labelPrenom = new JLabel(" Inserez votre prenom: ");
	private JTextField textPrenom = new JTextField(10);
	private JButton bouttonValider = new JButton("Valider");

	public SaveEleve() {
		
		// parametrage de l'ihm
		
		this.setTitle("Enregistrement du Nom et Prenom");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full ecran
		panelEnregistrement.setBackground(Color.ORANGE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		// ajout des objets graphiques au jpanel
                bouttonValider.setBackground(new Color(59, 89, 182));
                panelEnregistrement.setBackground(Color.gray);
		this.add(panelEnregistrement);
		panelEnregistrement.add(labelNom);
		panelEnregistrement.add(textNom);
		panelEnregistrement.add(labelPrenom);
		panelEnregistrement.add(textPrenom);
		panelEnregistrement.add(bouttonValider);
	}
	
	public String getTextNom() {
		
		String stringTextNom = textNom.getText().toString();
		return stringTextNom;
	}

	public String getTextPrenom() {
		
		String stringTextPrenom = textPrenom.getText().toString();
		return stringTextPrenom;
	}
	
	public void ecouteurBouttonValider (ActionListener ActionBoutValider) {
		
		bouttonValider.addActionListener(ActionBoutValider);
	}

	public void affichagePopUp(String message){

		JOptionPane.showMessageDialog(this, message);
	}	
}

