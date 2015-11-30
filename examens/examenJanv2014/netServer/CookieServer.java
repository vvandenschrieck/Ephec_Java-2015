package cookies.netServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import cookies.magasin.Cookie;
import cookies.magasin.MagasinCookies;
import cookies.magasin.RecetteInconnueException;
import cookies.magasin.SoldeInsuffisantException;
import cookies.magasin.StockInsuffisantException;

public class CookieServer implements Runnable{
	boolean stop = false;
	MagasinCookies mag; 
	
	public CookieServer(MagasinCookies mag){
		this.mag = mag;
	}
	public void stop(){
		this.stop=true;
	}
	public void run(){
		try{
			Socket soc;
			ServerSocket s = new ServerSocket(12345);

			//MagasinCookies mag = new MagasinCookies("Cookie's World", 1000);

			while(!stop){
				//Arrivee d'une requete : Ouverture de la connexion et des flux de communication
				soc = s.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				PrintWriter out = new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(soc.getOutputStream())), true);
				//Traitement de la requete
				String nomRecette = in.readLine();
				System.out.println(nomRecette);
				if(nomRecette == "QUIT"){
					break;
				}

				int numCookies = Integer.parseInt(in.readLine());
				Cookie[] cookies;
				String result = "";
				try {
					cookies = mag.fabriquerCookies(nomRecette, numCookies);
					System.out.println(cookies.length);
					double prix = 0;
					for(Cookie c : cookies){
						prix += c.prix();
						result += (c+" - ");
					}
					out.print("Voici les cookies demandés, la facture est de "+prix
								+ " euros. Bon appétit! (" + result+ ")\n");
					out.flush();
					
				} catch (SoldeInsuffisantException e) {
					out.println("Erreur : stock insuffisant pour la transaction.");
				} catch (RecetteInconnueException e){
					out.println("Erreur : La recette n'est pas à la carte du magasin");
				} catch (StockInsuffisantException e) {
					e.printStackTrace();
				}
			} 
			s.close();
		}
		catch(IOException e)
		{
			System.out.println("Erreur IO : Le serveur a crashé");

		}
	}
}
