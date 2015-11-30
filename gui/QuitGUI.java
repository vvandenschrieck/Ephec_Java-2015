package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class QuitGUI {
	public static void main(String []args ){
		// On crée la fenêtre
	    JFrame f = new JFrame ("Quit");
	    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    f.setSize (250, 100);
	    // On crée et ajoute le bouton quitter à la fenêtre
	    JButton quit = new JButton ("Quitter");
	    f.getContentPane().add (quit);
	    
	    // On crée le listener
	    MyListener listener = new MyListener();
	    // On écoute des événements de type "action" sur le bouton
	    quit.addActionListener (listener);
	    // On affiche la fenêtre
	    f.setVisible (true);
	}
}
