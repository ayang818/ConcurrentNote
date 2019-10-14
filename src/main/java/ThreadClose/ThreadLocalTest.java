package ThreadClose;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

public class ThreadLocalTest {

    private static String DB_URL = "jdbc:mysql://119.23.240.115:3306";
    private static String USERNAME = "root";
    private static String PASSWORD = "yfc1004210191";
    private static Properties dataMap = new Properties();
    // 重写initialValue，设置初始值
    // 使用ThreadLocal维持线程封闭性
    private static ThreadLocal<Connection> connectHolder = ThreadLocal.withInitial(() -> {
        try {
            dataMap.setProperty("user", USERNAME);
            dataMap.setProperty("password", PASSWORD);
            return DriverManager.getConnection(DB_URL, dataMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    });


    public static Connection getConnection() {
        // get方法到这个线程的Value
        Connection connection = connectHolder.get();
        return connection;
    }
}
