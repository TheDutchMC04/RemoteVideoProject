package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
		
	public static void main(String[] args) {
		
		Server letConnectObj = new Server();
		letConnectObj.letConnect();
	}
	
	void letConnect() {
		try {
			System.out.println("Waiting for client...");
			ServerSocket ss = new ServerSocket(9800);
			Socket soc = ss.accept();
			System.out.println("Connection Established");
			DataInputStream dIn = new DataInputStream(soc.getInputStream());
			boolean done = false;
			while(!done) {
			  byte messageType = dIn.readByte();
			  switch(messageType) {
			  case 1: 
			    System.out.println("Message recieved from the client.");
			    break;
				 default:
				   done = true;
				 }
				}
			}
			catch (IOException e) {
				//TODO Auto Generated Catch block
				System.out.println("Error: IOExcepton");
				e.printStackTrace();
			}
	}
}