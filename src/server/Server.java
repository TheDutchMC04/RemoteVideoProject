package server;

import javafx.util.Pair;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {

    private static String videoHeader = "https://www.youtube.com/watch?v=";

    Map<String, Pair<String, Integer>> links;

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
            while (!done) {
                byte messageType = dIn.readByte();
                switch (messageType) {
                    case 1:
                        System.out.println("Message recieved from the client.");
                        break;
                    default:
                        done = true;
                }
                dIn.readUTF();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
