package tp9;

import java.io.IOException;
import java.util.Scanner;

public class ChatConsole {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean isServer = (args[0].equals("true")? true : false);
		Chat chat = new Chat( isServer , 12345);
		if(isServer){
			String msg = chat.waitForMessage();
			System.out.println(msg);
		}
		while(true){
			System.out.print(">");
			String msg = sc.nextLine();
			if(msg=="STOP"){
				sc.close();
				System.exit(0);
			}
			chat.sendMessage(msg);
			msg = chat.waitForMessage();
			System.out.println(msg);
			
		}
		
	}

}
