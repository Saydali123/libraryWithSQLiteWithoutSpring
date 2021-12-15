package uz.elmurodov.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author Elmurodov Javohir, Tue 3:10 PM. 12/14/2021
 */
public class DbConfig {
    private static Connection connection;

    public static Connection conn() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(PropertyConfig.get("db.connection"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(){
        try {
            if (Objects.nonNull(connection) && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
