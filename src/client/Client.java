package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import client.gui.AccountGUI;
import server.data.Write;

public class Client {
	
	public static String name;
	public static String IP;
	public static int host;
	public static Socket socket;

	
	public static void Connect(String ename, String eIP, int ehost) {
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
			e.printStackTrace();
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
}