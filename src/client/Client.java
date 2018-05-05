package client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		
		Client ConnectObj = new Client();
		ConnectObj.Connect();
	}
	
	void Connect() {
		try {
			System.out.println("Client Started");
			Socket soc = new Socket("85.144.251.7", 9800);
			boolean Connected = true;
			DataOutputStream dOut = new DataOutputStream(soc.getOutputStream());
			dOut.writeByte(1);
			dOut.writeUTF("Sending a message to server... Waiting for response.");
			dOut.flush();
		}
		catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
