
package TaskExecution;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Client client = new Client();
        client.sendMessage("Hello Server");
    }

    private void sendMessage(String message) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 1080);
        OutputStream outputStream =  socket.getOutputStream();
        outputStream.write(message.getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String callBackMessgae = new String(inputStream.readAllBytes(), "UTF-8");
        System.out.println(callBackMessgae);
    }
}
