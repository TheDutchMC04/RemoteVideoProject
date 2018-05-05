package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import server.gui.ServerGUI;

public class Server extends Thread {
	
	private static String videoHeader = "https://www.youtube.com/watch?v=";
	private static List<String> currentAccounts = new ArrayList<String>();
	public static ServerSocket serverSocket = null;
	public static Socket socket = null;
	public static int host;
	
	public Server (int host) {
		
		this.host = host;
	}
	
	public static void StartServer(int host) {
		try {
			System.out.println("Waiting for client...");
			serverSocket = new ServerSocket(host);
			socket = serverSocket.accept();

			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			
			boolean done = false;
			while(!done) {
			  byte messageType = dataIn.readByte();
			  switch(messageType) {
			  case 1: 
				  String name = dataIn.readUTF();
				  if(currentAccounts.contains(name)) {System.out.println(name + " has already established a connection. Duplicate Exception!");}
				  else {System.out.println(name + " has established a connection."); currentAccounts.add(name);}
			    break;
				 default:
				   done = true;
				 }
			  
				}
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void run () {StartServer(host);}
}
