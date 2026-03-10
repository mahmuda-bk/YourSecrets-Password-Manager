
package yoursecrets;

import java.util.*;
import javax.crypto.SecretKey;

public class YourSecrets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UserDB db = new UserDB();
        String user = null;
        Vault vault = null;
        SecretKey key = null;

        while (true) {
            System.out.println("1. Register  2. Login  3. Exit");
            int ch = in.nextInt();
            in.nextLine();
            if (ch == 1) {
                System.out.print("Username: ");
                String u = in.nextLine();
                System.out.print("Password: ");
                String p = in.nextLine();
                if (db.register(u, p)) System.out.println("Registered.");
                else System.out.println("Username exists.");
            } else if (ch == 2) {
                System.out.print("Username: ");
                String u = in.nextLine();
                System.out.print("Password: ");
                String p = in.nextLine();
                if (db.login(u, p)) {
                    user = u;
                    key = EncryptionHelper.getKey(p);
                    vault = FileHelper.loadVault(user);
                    break;
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else {
                return;
            }
        }

        int opt;
        do {
            System.out.println("\n1. Add 2. View All 3. Search 4. Delete 5. Save & Logout");
            opt = in.nextInt();
            in.nextLine();
            switch (opt) {
                case 1 -> {
                    System.out.print("Site: ");
                    String s = in.nextLine();
                    System.out.print("Username: ");
                    String u = in.nextLine();
                    System.out.print("Password: ");
                    String p = in.nextLine();
                    vault.add(s, u, p, key);
                }
                case 2 -> vault.viewAll(key);
                case 3 -> {
                    System.out.print("Site: ");
                    vault.search(in.nextLine(), key);
                }
                case 4 -> {
                    System.out.print("Site: ");
                    vault.delete(in.nextLine());
                }
                case 5 -> FileHelper.saveVault(user, vault);
            }
        } while (opt != 5);

        System.out.println("Logged out. Bye!");
    }
}