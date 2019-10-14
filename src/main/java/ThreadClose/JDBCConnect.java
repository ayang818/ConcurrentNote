package ThreadClose;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ClassName JDBCConnect
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/12 10:25
 **/
public class JDBCConnect {
    private static String DB_URL = "";

    private static ThreadLocal<Connection> threadLocal = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    });

    public static Connection getConnection() {
        return threadLocal.get();
    }
}
