package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import client.gui.AccountGUI;
import client.gui.ClientGUI;
import client.gui.MenuGUI;
import server.data.Write;

public class Client {
	
	public static String name;
	public static String IP;
	public static int host;
	public static Socket socket;

	public static void main(String[] args) {
		
		new ClientGUI(null).initApp(null);
		
	}
	
	public static void Connect(String ename, String eIP, int ehost, MenuGUI instance) {
		try {
			
			name = ename;
			IP = eIP;
			host = ehost;			
			socket = new Socket(IP, host);		
		
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			
			dataOut.writeByte(1);
			dataOut.writeUTF(name);
			dataOut.flush();
		}
		catch (Exception e) {

			instance.frame.setVisible(false);
			new ClientGUI(null).initApp("Could not establish a connection.");

			//e.printStackTrace();
		}
	}
	
	public static void addVideo(String name, String video) {		
		
		try {	
			socket = new Socket(IP, host);
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			dataOut.writeByte(2);
			dataOut.writeUTF(name);
			dataOut.writeUTF(video);
			dataOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void disconnect(String name) {
		
		try {
			socket = new Socket(IP, host);
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			dataOut.writeByte(3);
			dataOut.writeUTF(name);
			dataOut.flush();
			socket.close();
			new ClientGUI(null).initApp("Client left the wormhole.");
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}