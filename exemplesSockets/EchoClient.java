package exemplesSockets;
import java.io.*;
import java.net.*;
/** Le processus client se connecte au site fourni dans la commande
 *   d'appel en premier argument et utilise le port distant 1234.
 */
public class EchoClient {
   static final int port = 1234;

   public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", port);
        BufferedReader in = new BufferedReader(
                               new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(
                             new BufferedWriter(
                                new OutputStreamWriter(socket.getOutputStream())),true);

        String str = "bonjour";
        for (int i = 0; i < 10; i++) {
           out.println(str);          // envoi d'un message
           str = in.readLine();      // lecture de l'�cho
        }
        System.out.println("END");     // message de terminaison
        out.println("END") ;
        in.close();
        out.close();
        socket.close();
   }
}