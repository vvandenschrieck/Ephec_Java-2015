package cookies.main;

import cookies.controleur.CookieGUIControleur;
import cookies.gui.MagasinFrame;
import cookies.magasin.MagasinCookies;
import cookies.netServer.CookieServer;

public class MagasinCookiesMain {
	public static void main(String [] args){
		//Création d'un magasin avec 10 euros d'investissement
		MagasinCookies monMagasin = new MagasinCookies("CookieFactory", 1000);
		
		//Création du serveur
		CookieServer server = new CookieServer(monMagasin);
		Thread t = new Thread(server);
		t.start();
	}
}
