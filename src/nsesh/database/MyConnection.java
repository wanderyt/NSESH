package nsesh.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    
    public MyConnection() {
        
    }
    
    /**
     * Get connection object from mysql jdbc
     * @return connection object
     */
    public static Connection getConnectionByJDBC(String ipAddress) {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dburl = "jdbc:mysql://" + ipAddress + ":3306/nsesh";
            connection = DriverManager.getConnection(dburl, "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return connection;
    }
    
    public static void main(String[] args) {
        Connection connection = MyConnection.getConnectionByJDBC("localhost");
        System.out.println(connection);
    }
    
}
