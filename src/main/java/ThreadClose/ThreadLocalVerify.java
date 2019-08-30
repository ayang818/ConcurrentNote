package ThreadClose;

import java.sql.Connection;
import java.sql.SQLException;

public class ThreadLocalVerify {
    public static void main(String[] args) throws InterruptedException, SQLException {
        Connection connection = ThreadLocalTest.getConnection();
        System.out.println(System.identityHashCode(connection));
        connection.nativeSQL("");
        Thread.sleep(2000);
        new Thread(() -> {
            Connection connection1 = ThreadLocalTest.getConnection();
            System.out.println(System.identityHashCode(connection1));
        }).start();
    }
}
