package ui;

import model.BankAccount;

import model.ListBankAccounts;

<<<<<<< HEAD
import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Scanner;

import persistence.JsonReader;

import persistence.JsonWriter;

//Represents the Banking Application
public class BankApp {
    private static final String JSON_STORE = "./data/work-acc.json";
    Scanner sc = new Scanner(System.in);
    ListBankAccounts myList = new ListBankAccounts("The account");
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: instantiates the banking application
    public BankApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
=======
import java.util.Scanner;

//Represents the Banking Application
public class BankApp {
    Scanner sc = new Scanner(System.in);
    ListBankAccounts myList = new ListBankAccounts();

    //EFFECTS: instantiates the banking application
    public BankApp() {
>>>>>>> origin/main
        System.out.println("Hello! Welcome to the Bank of British Columbia");
        runBank();
    }

    //EFFECTS: Running part of the banking application which performs all the banking functions.
    public void runBank() {
        while (true) {
            System.out.println("Please enter 1 for opening a new bank account, 2 for logging in your existing account");
            int option = sc.nextInt();
            if (option == 1) {
                displayOption1();
                System.out.println("Do you want to continue? enter y/n ");
                String ch = sc.next();
                if (ch.equals("n")) {
                    System.out.println("Thank you!You have successfully logged out");
                    break;
                }
            } else if (option == 2) {
                displayOption2();
                System.out.println("Would you still like to continue?");
                System.out.println("Enter y/n");
                String yn = sc.next();
                sc.nextLine();
                if (yn.equals("n")) {
                    System.out.println("Thank you!You have successfully logged out");
                    System.exit(0);
                }
            }

        }
    }

    //EFFECTS: Performs the creation of a new bak account when option 1 is chosen
//MODIFIES: this
    public void displayOption1() {
        System.out.println("To create a new account please enter the following details: ");
        System.out.println("Enter your full legal name ");
        String name = sc.next();
        sc.nextLine();
        System.out.println("Enter your email id ");
        String email = sc.next();
        sc.nextLine();
        System.out.println("Enter your residential address ");
        String address = sc.nextLine();
        System.out.println("Enter your mobile number ");
        String mob = sc.next();
        sc.nextLine();
        System.out.println("Enter your SIN ");
        String sin = sc.next();
        sc.nextLine();
        System.out.println("Enter your new password ");
        String password = sc.next();
        sc.nextLine();
<<<<<<< HEAD
        double balance = sc.nextDouble();
        sc.nextLine();
        BankAccount newAcc = new BankAccount(email, password, name, address, mob, sin, balance);
=======
        BankAccount newAcc = new BankAccount(email, password, name, address, mob, sin);
>>>>>>> origin/main
        myList.addAccount(newAcc);
        System.out.println("Account successfully created");
    }

    //EFFECTS: Allows the user to log in and execute his desired banking operations
    public void displayOption2() {
        System.out.println("To login ,please enter your email id and password ");
        System.out.println("Enter your email-id ");
        String id = sc.next();
        System.out.println("Enter your password ");
        String pass = sc.next();
        sc.nextLine();
        int num = myList.getSize();
<<<<<<< HEAD
        loadWorkRoom();
=======
>>>>>>> origin/main
        for (BankAccount b : myList.returnList()) {
            if (b.getEmail().equals(id) && b.getPassword().equals(pass)) {
                pb2(b);
            } else {
                num -= 1;
                if (num == 0) {
                    System.out.println("Account does not exist.Please restart the " + "system and create new account");
                    System.exit(0);
                }
            }
        }
    }

<<<<<<< HEAD
    //EFFECTS: Deposits the money in the bank account
=======
    //EFFECTS: Deposits money in the bank account
>>>>>>> origin/main
//MODIFIES: BankAccount b
    public void option1(BankAccount b) {
        System.out.println("How much money would you like to deposit to your account?");
        Double money = sc.nextDouble();
        sc.nextLine();
        b.deposit(money);
        System.out.println("Deposit successful");
    }

    //EFFECTS: Withdraws money from the bank account. Gives error message if amount asked is greater than account
    // balance
//MODIFIES: BankAccount b
    public void option2(BankAccount b) {
        System.out.println("How much money would you like to withdraw from your account?");
        Double money = sc.nextDouble();
        sc.nextLine();
        if (money <= b.getBankBalance()) {
            b.withdraw(money);
            System.out.println("Withdrawal Successful");
        } else {
            System.out.println("Amount entered is greater than bank balance."
                    + "Sorry, withdrawal is unsuccessful");
        }
    }
    //EFFECTS: Displays account information

    public void option3(BankAccount b) {
        System.out.println("Here is your bank balance" + b.getBankBalance());
        System.out.println("Other account details:");
        System.out.println("Name:" + " " + b.getName());
        System.out.println("Address:" + " " + b.getAddress());
        System.out.println("Email:" + " " + b.getEmail());
        System.out.println("Contact number:" + " " + b.getMobileNumber());
        System.out.println("SIN:" + " " + b.getSin());
    }

    //EFFECTS: Deletes the account
    public void option4(BankAccount b) {
        myList.delAccount(b);
        System.out.println("Account deleted");
        System.exit(0);
    }

<<<<<<< HEAD

=======
>>>>>>> origin/main
    //EFFECTS: Asks the user for continuing or exiting from the application and then performs the function requested
    public void exit() {
        System.out.println("Would you still like to continue?");
        System.out.println("Enter y/n");
        String yn = sc.next();
        if (yn.equals("n")) {
            System.out.println("Thank you!You have successfully logged out");
            System.exit(0);
        }
    }

    //EFFECTS: Checks which option has been entered and performs the appropriate banking operation accordingly.
    public void pb2(BankAccount b) {
        System.out.println("Welcome" + " " + b.getName());
        while (true) {
            System.out.println("Choose any of the following options,1: Deposit,2:Withdrawal,3:Account Summary,"
<<<<<<< HEAD
                    + "4: Deletion of account, 5:Loading data, 6:Saving data");
=======
                    + "4: Deletion of account");
>>>>>>> origin/main
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                option1(b);
                exit();
            } else if (ch == 2) {
                option2(b);
                exit();
            } else if (ch == 3) {
                option3(b);
                exit();
            } else if (ch == 4) {
                option4(b);
<<<<<<< HEAD
            } else if (ch == 5) {
                loadWorkRoom();
            } else if (ch == 6) {
                saveWorkRoom();

            }
        }
    }

    // EFFECTS: saves the workroom to file
    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(myList);
            jsonWriter.close();
            System.out.println("Saved " + myList.returnName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkRoom() {
        try {
            myList = jsonReader.read();
            System.out.println("Loaded " + myList.returnName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
=======
            }
        }
    }
>>>>>>> origin/main
}




