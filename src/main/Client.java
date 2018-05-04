package main;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		try {
			System.out.println("Client Started");
			Socket soc = new Socket("localhost", 9800);
			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		private static String videoHeader = "https://www.youtube.com/watch?v=";
		private static String[] videoIDs;
	}
}
