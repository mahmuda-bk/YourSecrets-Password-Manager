
package yoursecrets;

import java.io.Serializable;
import java.util.*;
import javax.crypto.SecretKey;

public class Vault implements Serializable {
    List<Credential> creds = new ArrayList<>();

    public void add(String site, String user, String pass, SecretKey key) {
        creds.add(new Credential(site, user, pass, key));
        System.out.println("Added successfully.");
    }

    public void viewAll(SecretKey key) {
        if (creds.isEmpty()) System.out.println("No credentials stored.");
        else for (Credential c : creds) c.show(key);
    }

    public void search(String site, SecretKey key) {
        boolean found = false;
        for (Credential c : creds) {
            if (c.website.equalsIgnoreCase(site)) {
                c.show(key);
                found = true;
            }
        }
        if (!found) System.out.println("Not found.");
    }

    public void delete(String site) {
        creds.removeIf(c -> c.website.equalsIgnoreCase(site));
        System.out.println("Deleted if existed.");
    }
}
