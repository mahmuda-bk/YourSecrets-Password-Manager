
package yoursecrets;

import java.io.Serializable;

public class User implements Serializable {
    String username, password;

    public User(String u, String p) {
        username = u;
        password = p;
    }

    public boolean check(String p) {
        return password.equals(p);
    }
}