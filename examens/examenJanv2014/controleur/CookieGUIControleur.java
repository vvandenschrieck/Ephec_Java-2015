package cookies.controleur;

import java.util.Map;

import javax.swing.JTextField;

import cookies.gui.MagasinFrame;
import cookies.magasin.Cookie;
import cookies.magasin.MagasinCookies;
import cookies.magasin.RecetteInconnueException;
import cookies.magasin.SoldeInsuffisantException;
import cookies.magasin.StockInsuffisantException;


public class CookieGUIControleur {
	MagasinCookies magasin;
	MagasinFrame gui;
	
	public CookieGUIControleur(MagasinCookies magasin) {
		this.magasin = magasin;
	}
	public void commande(Map<String, JTextField> commande){
		double aPayer = 0;
		for(Map.Entry<String, JTextField> entry : commande.entrySet()){
			String typeCookie = entry.getKey();
			int numCookies = Integer.parseInt(entry.getValue().getText());
			try {
				if(numCookies>0){
					Cookie[] cookies = magasin.fabriquerCookies(typeCookie, numCookies);
					for(Cookie c : cookies){
						aPayer += c.prix();
					}
				}
			} catch (SoldeInsuffisantException e) {
				gui.getPanelVente().afficheResultat("Erreur : Stock insuffisant pour "+typeCookie);
			} catch (StockInsuffisantException e) {
				gui.getPanelVente().afficheResultat("Erreur : Stock insuffisant");		
			} catch (RecetteInconnueException e) {
				gui.getPanelVente().afficheResultat("Erreur : Recette inconnue");	
			}
			entry.getValue().setText("0");
		}
		gui.getPanelVente().afficheResultat("Montant de la transaction : "+aPayer + " euros");
		
	}
	public void addGUI(MagasinFrame gui) {
		this.gui = gui;
	}
}
