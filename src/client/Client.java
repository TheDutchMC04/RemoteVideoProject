package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	
	private String name = "TheDutchMC04";
	
	public static void main(String[] args) throws InterruptedException {
		
		Client client = new Client();
		client.Connect();

	}
	
	void Connect() {
		try {
			Socket socket = new Socket("localhost", 9800);			
			
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			
			dataOut.writeByte(1);
			dataOut.writeUTF(name);
			dataOut.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}