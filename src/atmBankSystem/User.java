package atmBankSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    private byte[] pinHash;
    /**
     * The list of this user.
     */
    private ArrayList<Account> accounts;

    /**
     * Create a new user
     * @param firstName firstName the user's first name
     * @param lastName lastName the user's last name
     * @param pin the user account pin number
     * @param theBank the Bank object that the user is a customer of
     */

    public User(String firstName, String lastName, String pin, Bank theBank) {
        //set user's name
        this.firstName = firstName;
        this.lastName = lastName;
        //store the pin's MDS hash, rater than the original vale,for
        // security reasons

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error,caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        // get a new ,unique universal ID for the user.
        this.uuid=theBank.getNewUserUUID();
        //create empty list of accounts.
        this.accounts=new ArrayList<Account>();
        //print log message.
        System.out.printf("New user %s,%s with ID %s created.\n",lastName,firstName,this.uuid);
    }

    /**
     * Add an account for the user
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    /**
     *  Return the user's UUID
     * @return the uuid
     */
    public String getUUID(){
        return this.uuid;
    }

    /**
     * Check whether a given pin matches the true User pin
     * @param aPin the pin to check
     * @return whether the pin is valid or not
     */
    public boolean validatePin(String aPin){
        try {
            MessageDigest md=MessageDigest.getInstance("MDS");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),this.pinHash );
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error,caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }
}
