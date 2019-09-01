package ThreadClose;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

public class ThreadLocalTest {

    private static String DB_URL = "<你自己的数据库URL>";
    private static String USERNAME = "<数据库用户名>";
    private static String PASSWORD = "<数据库密码>";
    private static Properties dataMap = new Properties();
    // 使用ThreadLocal维持线程封闭性
    private static ThreadLocal<Connection> connectHolder = new ThreadLocal<>() {
        // 重写initialValue，设置初始值
        @Override
        public Connection initialValue() {
            try {
                Collections.synchronizedMap(new HashMap<>());
                dataMap.setProperty("user", USERNAME);
                dataMap.setProperty("password", PASSWORD);
                return DriverManager.getConnection(DB_URL, dataMap);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };


    public static Connection getConnection() {
        // get方法到这个线程的Value
        Connection connection = connectHolder.get();
        return connection;
    }
}
