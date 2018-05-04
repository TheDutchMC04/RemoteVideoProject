package main;

import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		try {
			System.out.println("Client Started");
			Socket soc = new Socket("localhost", 9800);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
