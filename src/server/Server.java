package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import server.gui.ServerGUI;
import server.gui.ServerThread;

public class Server extends Thread {
	
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
			
			while(true) {
			socket = serverSocket.accept();
			new ServerThread(socket).start();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run () {StartServer(host);}
}
