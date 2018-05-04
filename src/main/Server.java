package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
		
		public static void main(String[] args) {
			// TODO: Auto generated method stub
			
			try {
				System.out.println("Waiting for client...");
				ServerSocket ss = new ServerSocket(9800);
				Socket soc = ss.accept();
				System.out.println("Connection Established");
			}
			catch (IOException e) {
				//TODO Auto Generated Catch block
				e.printStackTrace();
			}
		}
}
