package database;
import javax.swing.*;
import java.sql.*;
public class ConnectionProvider {
    private String url,username,password;
    public ConnectionProvider(){
        url ="jdbc:mysql://localhost/mine";
        username="root";
        password="kiptoo";
    }
    public Connection getConnected() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection error", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

}}
