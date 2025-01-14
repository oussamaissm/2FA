
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;

public class UserDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/auth_system";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "ismaili";

    public UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load JDBC driver: " + e.getMessage(), e);
        }
    }

    public boolean validateCredentials(String username, String password) throws SQLException {
        String query = "SELECT password_hash FROM users WHERE username = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && password.equals(rs.getString("password_hash"));
            }
        }
    }
    
    public boolean createUser(String username, String password, String email) throws SQLException {
    	String query = "INSERT INTO users (username, password_hash, contact_info) VALUES (?, ?, ?)";
    	try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auth_system", "root", "ismaili");
                PreparedStatement ps = con.prepareStatement(query)) {

               ps.setString(1, username);
               ps.setString(2, SHA256Hasher.hashPassword(password)); 
               ps.setString(3, email);

               int result = ps.executeUpdate();
               return result > 0;
               
           }
    }

    public String getUserEmail(String username) throws SQLException {
        String query = "SELECT contact_info FROM users WHERE username = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("contact_info");
                }
            }
        }
        return null;
    }
    
    public boolean updatePassword(String email, String newPassword) throws SQLException {
        String sql = "UPDATE users SET password_hash = ? WHERE contact_info = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        		PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newPassword); 
            ps.setString(2, email); 
            
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error updating password", e);
        }
    }
}