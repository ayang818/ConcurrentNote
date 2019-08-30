package ThreadClose;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalTest {

    private static String DB_URL = "http://119.23.240.115:3306";

    // 使用ThreadLocal维持线程封闭性
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        // 创建匿名类并重写其中的initialValue方法
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Connection getCollection() {
        return connectionHolder.get();
    }
}
