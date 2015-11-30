package reservation_vols;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ReservationClient {
	static String serverIP; 
	static int port;
	/**
	 * Cette methode effectue une reservation de vol sur le serveur de reservation
	 * @param vol le nom du vol
	 * @param nom le nom du passager
	 * @param prenom le prenom du passger
	 * @param numID le numero d'identite du passager
	 * @return le resultat de la reservation
	 * @throws IOException en cas d'erreur lors de la communication
	 */
	public static String reservation(String vol, String nom, String prenom, int numID) throws IOException{
		//1. 
		//
		Socket socket = new Socket(serverIP, port);
		//2. 
		//
		BufferedReader in = new BufferedReader(
		                       new InputStreamReader(
		                    		   socket.getInputStream()));
		PrintWriter out = new PrintWriter(
		                     new BufferedWriter(
		                    		 new OutputStreamWriter(
		                    				 socket.getOutputStream())),true);
		//3. 
		//
		out.println(vol);
		out.println(nom);
		out.println(prenom);
		out.println(numID);
		//4. 
		//
		String result = in.readLine();
		//5. 
		//
		in.close();
		out.close();
		socket.close();
		return result;
	}
	public static void main(String[] args) {
		serverIP="127.0.0.1";
		port = 12345;
		try {
			System.out.println(reservation("Bxl-Paris", "Van den Schrieck", "Virginie", 12345));
			System.out.println(reservation("Bxl-Paris", "Van den Schrieck", "Virginie", 12345));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
