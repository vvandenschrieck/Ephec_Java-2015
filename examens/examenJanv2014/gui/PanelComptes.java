package cookies.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cookies.controleur.CookieGUIControleur;
import cookies.magasin.MagasinCookies;

public class PanelComptes extends JPanel implements Observer{
	MagasinCookies magasin;
	CookieGUIControleur controleur;
	Box verticalBox; 
	public PanelComptes(MagasinCookies magasin, CookieGUIControleur controleur) {
		this.magasin = magasin;
		this.controleur = controleur;
		magasin.addObserver(this);
		draw();
	}
	
	private void draw(){
		this.removeAll();
		verticalBox = Box.createVerticalBox();
		JLabel entete = new JLabel("Bilan financier");
		entete.setAlignmentX(CENTER_ALIGNMENT);
		//verticalBox.add(Box.createRigidArea(new Dimension(30, 30)));
		verticalBox.add(entete);
		verticalBox.add(Box.createRigidArea(new Dimension(20, 20)));
		
		
		Box ligne = Box.createHorizontalBox();
		ligne.add(new JLabel("Valeur du stock : "));
		ligne.add(new JLabel(magasin.valeurStock() + " euros"));
		verticalBox.add(ligne);
		
		ligne = Box.createHorizontalBox();
		ligne.add(new JLabel("Solde du compte : "));
		ligne.add(new JLabel(magasin.getSolde() + " euros"));
		verticalBox.add(ligne);
		
		ligne = Box.createHorizontalBox();
		ligne.add(new JLabel("Bilan : "));
		ligne.add(new JLabel(magasin.getBilan() + " euros"));
		verticalBox.add(ligne);
		
		verticalBox.add(getVentes());
		
		this.add(verticalBox);
		this.setBackground(Color.white);
		
		
		
	}
	private Box getVentes(){
		ArrayList<String> ventes = magasin.getVentes();
		Box tabVentes = Box.createVerticalBox();
		for(String vente : ventes){
			tabVentes.add(new JLabel(vente));
		}
		return tabVentes;
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		draw();
		
	}

	
}
