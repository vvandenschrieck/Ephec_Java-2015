package exemplesSockets;
import java.io.*;
import java.net.*;

public class EchoServer {
   static final int port = 1234;
   public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(port);
        Socket soc = s.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        PrintWriter out = new PrintWriter(
                             new BufferedWriter(
                                new OutputStreamWriter(soc.getOutputStream())), true);

        while (true) {
           String str = in.readLine();          // lecture du message
           if (str.equals("END")) break;
           System.out.println("ECHO = " + str);   // trace locale
           out.println(str);                     // renvoi d'un �cho
        }
        in.close();
        out.close();
        soc.close();
   }
}