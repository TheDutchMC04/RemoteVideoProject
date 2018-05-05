package client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.UUID;

public class Client {

	public static final UUID uuid = UUID.randomUUID();
	private static String links = "https://www.youtube.com/watch?v=07VosGU5uUY&list=PLKfBeWpy5-kTTuUft2-FwZxRjKGHS46Ci&index=12";
	
	public static void main(String[] args) {
		
		Client ConnectObj = new Client();
		ConnectObj.Connect();
	}
	
	void Connect() {
		try {
			System.out.println("Client Started");
			Socket soc = new Socket("localhost", 9800);
			DataOutputStream dOut = new DataOutputStream(soc.getOutputStream());
			dOut.writeByte(1);
			dOut.writeUTF(uuid.toString());
			dOut.writeUTF(links);
			dOut.flush();
		}
		catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}