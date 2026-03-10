
package yoursecrets;

import java.io.*;
import java.util.*;

public class UserDB {
    private static final String FILE = "users.db";
    Map<String, User> users = new HashMap<>();

    public UserDB() {
        load();
    }

    void load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            users = (Map<String, User>) in.readObject();
        } catch (Exception ignored) {}
    }

    void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(users);
        } catch (Exception e) {
            System.out.println("Failed to save users.");
        }
    }

    public boolean register(String u, String p) {
        if (users.containsKey(u)) return false;
        users.put(u, new User(u, p));
        save();
        return true;
    }

    public boolean login(String u, String p) {
        return users.containsKey(u) && users.get(u).check(p);
    }
}
