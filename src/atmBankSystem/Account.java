package atmBankSystem;

import java.util.ArrayList;

public class Account {
    /**
     * The name of the account.
     */
    private String name;
    /**
     * The balance of the account.
     */
    private double balance;
    /**
     * The account ID number.
     */
    private String uuid;
    /**
     * The user object that owns this account.
     */
    private User holder;
    /**
     * The list of transaction for this user.
     */
    private ArrayList<Transaction> transactions;
}
