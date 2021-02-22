package atmBankSystem;

import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {
        // init scanner
        Scanner in = new Scanner(System.in);
        // init Bank
        Bank theBank = new Bank("Bank of Drausin");
        //add a user,which also creates a savings account
        User aUser = theBank.addUsr("John", "Done", "1234");
        //add a checking account for our user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);
        User curUser;
        while (true) {
            //stay in the login prompt until successful login
            curUser = Atm.mainMenuPrompt(theBank, in);
            //stay in main menu until user quits
            Atm.printUserMenu(curUser, in);
        }
    }

    /**
     * Print the Atm's login menu
     *
     * @param theBank the Bank object whose account to use
     * @param in      the Scanner object to use for user
     * @return the authenticated User object
     */
    public static User mainMenuPrompt(Bank theBank, Scanner in) {
        //init
        String userID;
        String pin;
        User authUser;
        //prompt the user for user ID/pin combo until a correct is reached
        do {
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.println("Enter user ID: ");
            userID = in.nextLine();
            System.out.println("Enter pin: ");
            pin = in.nextLine();
            // try to get the user object corresponding to the ID and pin combo
            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorrect user ID/pin combination.  " + "Please try again. ");

            }
        } while (authUser == null);//continue looping until successful login
        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner in) {
        //print a summary of the user's accounts
        theUser.printAccountsSummary();
        //init
        int choice;
        //user menu
        do {
            System.out.printf("Welcome %s,what would you like to do? ",
                    theUser.getFirstName());
            System.out.println("1) Show account transaction history: ");
            System.out.println("2) Withdrawal: ");
            System.out.println("3) Deposit: ");
            System.out.println("4) Transfer: ");
            System.out.println("5) Quit: ");
            System.out.println();
            System.out.println("Enter choice");
            choice = in.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice .Please choose 1-5");
            }
        } while (choice < 1 || choice > 5);
        //process the choice
        switch (choice) {
            case 1:
                Atm.showTransHistory(theUser, in);
                break;
            case 2:
                Atm.withdrawFunds(theUser, in);
                break;
            case 3:
                Atm.depositFunds(theUser, in);
                break;
            case 4:
                Atm.transferFunds(theUser, in);
                break;
        }
        //redisplay this menu unless the user wants to quit
        if (choice != 5) {
            Atm.printUserMenu(theUser, in);
        }
    }

    /**
     * Show the transaction history for an account
     *
     * @param theUser the logged-in User object
     * @param in      the Scanner object used for user input
     */
    public static void showTransHistory(User theUser, Scanner in) {
        int theAcct;
        //get account whose transaction history to look at
        do {
            System.out.printf("Enter the number(1-%d) of the account\n" +
                            "whose transaction you want to see: ",
                    theUser.numAccounts());
            theAcct = in.nextInt() - 1;
            if (theAcct < 0 || theAcct >= theUser.numAccounts()) {
                System.out.println("Invalid accounts .Please try again");
            }
        } while (theAcct < 0 || theAcct >= theUser.numAccounts());
        //print the transaction history
        theUser.printAccountsTransHistory(theAcct);
    }

    /**
     * Process transferring funds form one account to another
     *
     * @param theUser the logged-in User object
     * @param in      the Scanner object used for user input
     */
    public static void transferFunds(User theUser, Scanner in) {
        //init
        int formAcct;
        int toAcct;
        double amount;
        double acctBal;
        //get the account to transfer form
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer form: ");
            formAcct = in.nextInt() - 1;
            if (formAcct < 0 || formAcct >= theUser.numAccounts()) {
                System.out.println("Invalid accounts .Please try again");
            }
        } while (formAcct < 0 || formAcct >= theUser.numAccounts());
        acctBal = theUser.getAcctBalance(formAcct);
        //get the account to transfer to
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer form: ");
            toAcct = in.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid accounts .Please try again");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());
        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max$%.02f): $",
                    acctBal);
            amount = in.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero. ");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater then\n " +
                        "balance of $%.02f.\n", acctBal);
            }
        } while (amount < 0 || amount > acctBal);
        //finally ,do the transfer
        theUser.addAcctTransaction(formAcct, -1 * amount, String.format("" +
                "Transfer to account %s ", theUser.getAcctUUID(toAcct)));
        theUser.addAcctTransaction(toAcct, -1 * amount, String.format("" +
                "Transfer to account %s ", theUser.getAcctUUID(toAcct)));
    }

    /**
     * Process a fund withdraw form an account
     *
     * @param theUser the logged-in User object
     * @param in      the Scanner object user of user input
     */
    public static void withdrawFunds(User theUser, Scanner in) {
        //init
        int formAcct;
        double amount;
        double acctBal;
        String memo;
        //get the account to transfer form
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer form: ");
            formAcct = in.nextInt() - 1;
            if (formAcct < 0 || formAcct >= theUser.numAccounts()) {
                System.out.println("Invalid accounts .Please try again");
            }
        } while (formAcct < 0 || formAcct >= theUser.numAccounts());
        acctBal = theUser.getAcctBalance(formAcct);
        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max$%.02f): $",
                    acctBal);
            amount = in.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero. ");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater then\n " +
                        "balance of $%.02f.\n", acctBal);
            }
        } while (amount < 0 || amount > acctBal);
        // gobble up rest of previous input
        in.nextLine();
        //get a memo
        System.out.println("Enter a memo");
        memo = in.nextLine();
        //do the withdraw
        theUser.addAcctTransaction(formAcct, -1 * amount, memo);
    }

    /**
     * Process a fund deposit form an account
     * @param theUser the logged-in User object
     * @param in  the Scanner object user of user input
     */
    public static void depositFunds(User theUser, Scanner in) {
        //init
        int toAcct;
        double amount;
        double acctBal;
        String memo;
        //get the account to transfer form
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer form: ");
            toAcct = in.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid accounts .Please try again");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());
        acctBal = theUser.getAcctBalance(toAcct);
        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max$%.02f): $",
                    acctBal);
            amount = in.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero. ");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater then\n " +
                        "balance of $%.02f.\n", acctBal);
            }
        } while (amount < 0 || amount > acctBal);
        // gobble up rest of previous input
        in.nextLine();
        //get a memo
        System.out.println("Enter a memo");
        memo = in.nextLine();
        //do the withdraw
        theUser.addAcctTransaction(toAcct,  amount, memo);
    }
}

