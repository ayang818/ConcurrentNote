package TaskExecution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) throws IOException {
        ExecutorDemo executorDemo = new ExecutorDemo();
        Executor executor = Executors.newFixedThreadPool(100);
        ServerSocket server = new ServerSocket(1080);
        while (true) {
            Socket socket = server.accept();
            Runnable task = () -> {
                executorDemo.handlerRequest(socket);
            };
            executor.execute(task);
        }
    }

    private void handlerRequest(Socket socket) {
        System.out.println("rebase test2");
    }
}
