package util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHashUtil {
    public static String hashPass(String plainPassword){
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    public static boolean checkPass(String plainPassword, String dbPassword){
        return BCrypt.checkpw(plainPassword, dbPassword);
    }
}
