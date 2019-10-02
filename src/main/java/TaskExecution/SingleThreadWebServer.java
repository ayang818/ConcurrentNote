package TaskExecution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1080);
        while(true) {
            Socket connection = serverSocket.accept();
            System.out.println(connection.isConnected());
        }
    }
}
