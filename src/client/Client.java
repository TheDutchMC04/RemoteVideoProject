package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends Thread {
	
	public String name;
	public String IP;
	public int host;
	
	public Client (String name, String IP, int host) {
		
		this.name = name;
		this.IP = IP;
		this.host = host;
		
	}
	
	void Connect(String name, String IP, int host) {
		try {
			Socket socket = new Socket(IP, host);			
			
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
	
	@Override
	public void run () {Connect(name, IP, host);}
}