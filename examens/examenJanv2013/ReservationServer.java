package reservation_vols;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationServer {
	private static Map<String, Vol> vols;
	private static boolean volsComplets(){
		for(Vol v : vols.values()){
			if(!v.estComplet())
				return false; //un vol incomplet trouve
		}
		return true;
	}
	public static void main(String [] args) throws IOException{
		//Creation des vols reservables
		vols =new HashMap<String,Vol>();
		vols.put("Bxl-Paris", new Vol("Bxl-Paris", 4));
		vols.put("Bxl-Londres", new Vol("Bxl-Londres", 10));
		vols.put("Paris-NY", new Vol("Paris-NY", 15));
		ServerSocket s=null;
		Socket soc;
		s = new ServerSocket(12345);
			
		while(!volsComplets()){
			//Arrivee d'une requete : Ouverture de la connexion et des flux de communication
			soc = s.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(soc.getOutputStream())), true);
			//Traitement de la requete
			String vol = in.readLine();
			String nomPass = in.readLine();
			String prenomPass = in.readLine();
			int numIDPass = Integer.parseInt(in.readLine());
			//Tentative de reservation
			if(vols.containsKey(vol)){
				try {
					vols.get(vol).ajoutePassager(new Personne(nomPass, prenomPass, numIDPass));
					out.println("Reservation effectuee avec succes");
				} catch (VolCompletException e) {
					out.println("Erreur : Plus de place sur le vol "+vol);
				} catch (DejaEnregistreException e) {
					out.println("Erreur : Vous etes deja enregistre sur ce vol");
				}
			}	
			else {
				out.println("Erreur : Le vol demande n'existe pas\n");
			}

		} 
		s.close();

	}

}


