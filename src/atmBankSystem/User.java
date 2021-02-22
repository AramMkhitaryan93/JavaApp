package atmBankSystem;

import java.util.ArrayList;

public class User {
    /**
     * The first name of the user.
     */
    private String firstName;
    /**
     * The last name of the user.
     */
    private String lastName;
    /**
     * The ID number of the user.
     */
    private String uuid;
    /**
     * The MD5 hash of the user's pin number.
     */
    private String pinHash;
    /**
     * The list of this user.
     */
    private ArrayList<Account> accounts;

    public User() {
    }
}
