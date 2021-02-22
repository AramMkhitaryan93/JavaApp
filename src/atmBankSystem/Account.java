package atmBankSystem;

import java.util.ArrayList;

public class Account {
    /**
     * The name of the account.
     */
    private String name;
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

    /**
     *
     * @param name the name of the account
     * @param holder the User object that holds this account
     * @param theBank the bank that issues the account
     */
    public Account(String name,User holder,Bank theBank){
        //set the account name and holder
        this.name=name;
        this.holder=holder;
        //get new account UUID
        this.uuid=theBank.getNewAccountUUID();
        // init transaction

        this.transactions=new ArrayList<Transaction>();
    }
    /**
     *  Return the user's UUID
     * @return the uuid
     */
    public String getUUID(){
        return this.uuid;
    }
}
