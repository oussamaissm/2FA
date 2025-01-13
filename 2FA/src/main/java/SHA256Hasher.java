
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA256Hasher {

    // Method to hash a password with SHA-256
    public static String hashPassword(String plainPassword) {
        try {
            // Get the MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Perform hashing
            byte[] hashedBytes = digest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));

            // Convert the hashed bytes to a Base64-encoded string
            return Base64.getEncoder().encodeToString(hashedBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available!", e);
        }
    }
}
