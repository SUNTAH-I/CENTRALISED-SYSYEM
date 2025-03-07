package Group25;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    
    private static final int WORK_FACTOR = 12; // Cost factor for security

    // Method to hash a password
    public static String hashPassword(String plainPassword) {
        String salt = BCrypt.gensalt(WORK_FACTOR); // Generate salt
        return BCrypt.hashpw(plainPassword, salt); // Hash password with salt
    }

    // Method to check if a password matches the stored hash
    public static boolean checkPassword(String plainPassword, String storedHash) {
        return BCrypt.checkpw(plainPassword, storedHash);
    }
}
