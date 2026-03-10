package yoursecrets;

import java.io.Serializable;
import javax.crypto.SecretKey;

public class Credential implements Serializable {
    String website, username, encryptedPassword;

    public Credential(String website, String username, String password, SecretKey key) {
        this.website = website;
        this.username = username;
        this.encryptedPassword = EncryptionHelper.encrypt(password, key);
    }

    public void show(SecretKey key) {
        System.out.println("Website: " + website);
        System.out.println("Username: " + username);
        System.out.println("Password: " + EncryptionHelper.decrypt(encryptedPassword, key));
    }
}


