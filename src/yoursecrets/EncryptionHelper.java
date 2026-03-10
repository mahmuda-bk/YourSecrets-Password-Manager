
package yoursecrets;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class EncryptionHelper {
    public static SecretKey getKey(String password) {
        byte[] key = Arrays.copyOf(password.getBytes(), 16); // 128-bit key
        return new SecretKeySpec(key, "AES");
    }

    public static String encrypt(String data, SecretKey key) {
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(c.doFinal(data.getBytes()));
        } catch (Exception e) {
            return null;
        }
    }

    public static String decrypt(String data, SecretKey key) {
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, key);
            return new String(c.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) {
            return "Decryption error";
        }
    }
}
