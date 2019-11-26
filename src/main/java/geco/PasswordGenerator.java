package geco;

import java.util.UUID;

/**
 * Random password generator.
 */
public final class PasswordGenerator {
    
    /**
     * Generates a new password on the fly.
     * The password is made up of 8 characters.
     * @return The generated password
     */
    public static String getRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}

