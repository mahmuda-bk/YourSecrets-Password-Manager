
package yoursecrets;

import java.io.*;

public class FileHelper {
    public static Vault loadVault(String user) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("vault_" + user + ".db"))) {
            return (Vault) in.readObject();
        } catch (Exception e) {
            return new Vault();
        }
    }

    public static void saveVault(String user, Vault v) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vault_" + user + ".db"))) {
            out.writeObject(v);
        } catch (Exception e) {
            System.out.println("Error saving vault.");
        }
    }
}