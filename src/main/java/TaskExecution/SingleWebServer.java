package TaskExecution;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SingleWebServer {
    public static void main(String[] args) throws IOException {
        SingleWebServer singleWebServer = new SingleWebServer();
        singleWebServer.runServer();
    }

    private void runServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("remote address is" + socket.getRemoteSocketAddress());
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            String message = new String(bytes, StandardCharsets.UTF_8);
            String receiveMessage = "receive message " + message;
            System.out.println(receiveMessage);

            OutputStream outputStream = socket.getOutputStream();
            String callBackMessgae = "We receive message" + receiveMessage;
            outputStream.write(callBackMessgae.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        }
    }
}
