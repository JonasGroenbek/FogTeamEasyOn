package DBAccess;

import FunctionLayer.LoginSampleException;

public class PasswordSecurity {

    // 10-31 is valid
    private static int workload = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);
        return (hashed_password);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) throws LoginSampleException {
        if ((null == stored_hash || !stored_hash.startsWith("$2a$") || BCrypt.checkpw(password_plaintext, stored_hash))) {
            return (BCrypt.checkpw(password_plaintext, stored_hash));
        }  else {
            throw new LoginSampleException("Username and password does not match");
        }

    }

}
