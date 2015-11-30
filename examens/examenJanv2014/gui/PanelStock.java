package cookies.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cookies.controleur.CookieGUIControleur;
import cookies.magasin.Ingredient;
import cookies.magasin.MagasinCookies;

public class PanelStock extends JPanel implements Observer{
	MagasinCookies magasin;
	CookieGUIControleur controleur;
	Box verticalBox; 
	public PanelStock(MagasinCookies magasin, CookieGUIControleur controleur) {
		this.magasin = magasin;
		this.controleur = controleur;
		magasin.addObserver(this);
		draw();
	}
	public void draw(){
		this.removeAll();
		Box verticalBox = Box.createVerticalBox();
		JLabel entete = new JLabel("Etat des stocks");
		//entete.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		entete.setAlignmentX(CENTER_ALIGNMENT);
		//verticalBox.add(Box.createRigidArea(new Dimension(30, 30)));
		verticalBox.add(entete);
		verticalBox.add(Box.createRigidArea(new Dimension(20, 20)));
		
		ajouterTableauStock(verticalBox);

		verticalBox.add(Box.createRigidArea(new Dimension(20, 20)));
		JLabel valeur = new JLabel();
		valeur.setText(magasin.valeurStock() + " euros");
		verticalBox.add(valeur);
		verticalBox.add(Box.createRigidArea(new Dimension(20, 20)));
		this.add(verticalBox);
		this.setBackground(Color.white);
	}
	
	private void ajouterTableauStock(Container c){
		System.out.println("Stock : "+ magasin.getStock());
		for(Map.Entry<Ingredient, Integer> entry : magasin.getStock()){
			Ingredient ing = entry.getKey();
			int nbUnites = entry.getValue();
			Box ligne = Box.createHorizontalBox();
			ligne.add(new JLabel(ing.getName()+ " - "));
			ligne.add(new JLabel(" "+ing.getPrixUnitaire()+ " euros/dose - "));
			ligne.add(new JLabel(""+nbUnites + " doses en stock"));
			//ligne.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			c.add(ligne);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		draw();
		
	}

	
}
