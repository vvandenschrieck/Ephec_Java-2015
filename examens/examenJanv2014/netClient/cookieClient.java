package cookies.netClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class cookieClient {
	static String serverIP; 
	static int port;
	/**
	 * Cette methode effectue une commande de cookies au magasin de cookie
	 * @param nomCookie : Le nom du cookie commandé
	 * @param numCookies : Le nombre de cookies de type nomCookie commandés
	 * @return le resultat de la commande
	 * @throws IOException en cas d'erreur lors de la communication
	 */
	public static String acheteCookies(String nomCookie, int numCookies) throws IOException{
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
		out.println(nomCookie);
		out.println(numCookies);
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
			System.out.println(acheteCookies("Cookie au cacao", 2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
