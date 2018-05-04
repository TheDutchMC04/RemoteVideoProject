package client;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		try {
			System.out.println("Client Started");
			Socket soc = new Socket("localhost", 9800);
			DataOutputStream dOut = new DataOutputStream(soc.getOutputStream());
			dOut.writeByte(1);
			dOut.writeUTF("Sending a message to server... Waiting for response.");
			dOut.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
