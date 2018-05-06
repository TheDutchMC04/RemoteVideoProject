package server.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import server.Server;
import server.data.Write;

public class ServerThread extends Thread {

	Socket socket;
	
	public ServerThread(Socket socket) {
		
		this.socket = socket;
		
	}
	
	@Override
	public void run () {
		
		try {
		DataInputStream dataIn = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
		
		boolean done = false;
		while(true) {
		  byte messageType = dataIn.readByte();
		  switch(messageType) {
		  case 1:
			  String name = dataIn.readUTF();
			  System.out.println(name + " has established a connection."); 
		  case 2: 
			  String name2 = dataIn.readUTF();
			  String videolink = dataIn.readUTF();
			  System.out.println(name2 + " has sent a new video, \"" + videolink + "\"."); 
			  Write.AddData(name2, videolink);
		  case 3: 
			  String name3 = dataIn.readUTF();
			  System.out.println(name3 + " has disconnected.");
			  socket.close();
		    break;
			 //default:
			   //done = true;
			 }

			}
	
		} catch (Exception e) {

		}
		
	}
	
}
