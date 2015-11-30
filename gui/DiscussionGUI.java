package gui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DiscussionGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//Création et paramétrisation de la fenêtre
		JFrame f = new JFrame ("Ma première fenêtre");
		f.setSize (250, 200);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		// Création du bouton envoyer
		JButton send = new JButton ("Envoyer");
		 
		// Création de la zone de texte pour taper son message
		JTextField text = new JTextField ("Bonjour !");
		text.setPreferredSize (new Dimension (250, 50));
		 
		// Création de la boite horizontale
		Box bottom = Box.createHorizontalBox();
		 
		bottom.add (text);
		bottom.add (send);
		 
		// Création de la zone de texte du haut
		JTextArea textarea = new JTextArea ("Discussion ...");
		textarea.setPreferredSize (new Dimension (250, 150));
		textarea.setEditable (false);
		 
		// Création de la boite verticale
		Box main = Box.createVerticalBox();
		 
		main.add (textarea);
		main.add (bottom);
		 
		// On met le tout sur la fenêtre et on l'affiche
		Container contentpane = f.getContentPane();
		contentpane.add (main);
		 
		f.setVisible (true);
	}
}
