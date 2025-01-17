import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/auth_system";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "ismaili";

    public UserDAO() {
        try {
            // Ensure the JDBC driver is loaded
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
}