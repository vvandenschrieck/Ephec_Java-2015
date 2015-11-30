package cookies.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cookies.controleur.CookieGUIControleur;
import cookies.magasin.MagasinCookies;
import cookies.magasin.RecetteCookie;

public class PanelVente extends JPanel implements ActionListener{
	MagasinCookies magasin;
	//Elements interactifs
	Map<String, JTextField> choixCookie;  
	JLabel resultat;
	JButton okButton;
	JButton cancelButton;
	CookieGUIControleur controleur;
	public PanelVente(MagasinCookies magasin, CookieGUIControleur controleur) {
		
		this.magasin = magasin;
		this.controleur = controleur;
		
		choixCookie = new HashMap<String, JTextField>();
		Box verticalBox = Box.createVerticalBox();
		JLabel entete = new JLabel("Choisissez vos cookies :");
		entete.setAlignmentX(CENTER_ALIGNMENT);
		//verticalBox.add(Box.createRigidArea(new Dimension(30, 30)));
		verticalBox.add(entete);
		verticalBox.add(Box.createRigidArea(new Dimension(20, 20)));
		
		ajouterTableauChoix(verticalBox);

		verticalBox.add(Box.createRigidArea(new Dimension(20, 20)));
		resultat = new JLabel();
		verticalBox.add(resultat);
		verticalBox.add(Box.createRigidArea(new Dimension(20, 20)));
		okButton = new JButton("Commander");
		okButton.addActionListener(this);
		cancelButton = new JButton("Reset");
		cancelButton.addActionListener(this);
		Box ligneBoutons = Box.createHorizontalBox();
		ligneBoutons.add(okButton);
		ligneBoutons.add(cancelButton);
		verticalBox.add(ligneBoutons);
		this.add(verticalBox);
		this.setBackground(Color.white);
	}
	public void ajouterTableauChoix(Container c){
		for(Map.Entry<String, RecetteCookie> entry : magasin.getRecettes().entrySet()){
			String nomRecette = entry.getKey();
			Box ligne = Box.createHorizontalBox();
			JTextField field = new JTextField("0",3);
			choixCookie.put(nomRecette, field);
			field.setMaximumSize(new Dimension(30, 30));
			field.setAlignmentX(RIGHT_ALIGNMENT);
			ligne.add(new JLabel(nomRecette + " : "));
			ligne.add(Box.createHorizontalGlue());
			ligne.add(field);
			ligne.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			c.add(ligne);
		}
	}
	
    public void actionPerformed (ActionEvent event)
    {
    	if(event.getSource()==okButton){
    		controleur.commande(choixCookie);
   		} 		
    	if(event.getSource()==cancelButton){
    		for(Map.Entry<String, JTextField> entry : choixCookie.entrySet()){
    			entry.getValue().setText("0");
    		}
    	}
    }
	public void afficheResultat(String string) {
		resultat.setText(string);
	}
	
	
}
