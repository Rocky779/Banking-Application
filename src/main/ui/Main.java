package ui;

import model.BankAccount;

import model.ListBankAccounts;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("methodlength")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListBankAccounts myList = new ListBankAccounts();
        System.out.println("Hello! Welcome to the Bank of British Columbia");
        while (true) {
            System.out.println("Please enter one of the following digits");
            System.out.println("Enter 1 for opening a new bank account");
            System.out.println("Enter 2 for logging in your existing account");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("To create a new account please enter the following details: ");
                System.out.println("Enter your full legal name ");
                String name = sc.next();
                sc.nextLine();
                System.out.println("Enter your email id ");
                String email = sc.next();
                sc.nextLine();
                System.out.println("Enter your residential address ");
                String address = sc.nextLine();
                //sc.nextLine();
                System.out.println("Enter your mobile number ");
                String mob = sc.next();
                sc.nextLine();
                System.out.println("Enter your SIN ");
                String sin = sc.next();
                sc.nextLine();
                System.out.println("Enter your new password ");
                String password = sc.next();
                sc.nextLine();
                BankAccount newAcc = new BankAccount(email, password, name, address, mob, sin);
                myList.addAccount(newAcc);
                System.out.println("Account successfully created");
                System.out.println("Do you want to continue? enter y/n ");
                String ch = sc.next();
                if (ch.equals("y")) {
                    continue;
                } else {
                    break;
                }


            } else if (option == 2) {
                System.out.println("To login ,please enter your email id and password ");
                System.out.println("Enter your email-id ");
                String id = sc.next();
                //sc.nextLine();
                System.out.println("Enter your password ");
                String pass = sc.next();
                sc.nextLine();
                int num = myList.getSize();
                for (BankAccount b : myList.returnList()) {
                    if (b.getEmail().equals(id) && b.getPassword().equals(pass)) {
                        System.out.println("Welcome" + " " + b.getName());
                        while (true) {
                            System.out.println("Choose any of the following options");
                            System.out.println("Enter 1 for adding money to yor account");
                            System.out.println("Enter 2 for withdrawing money from account");
                            System.out.println("Enter 3 for viewing your account balance and other details");
                            System.out.println("Enter 4 for deleting your account");
                            int ch = sc.nextInt();
                            sc.nextLine();
                            if (ch == 1) {
                                System.out.println("How much money would you like to deposit to your account?");
                                Double money = sc.nextDouble();
                                sc.nextLine();
                                b.deposit(money);
                                System.out.println("Deposit successful");
                                System.out.println("Would you still like to continue?");
                                System.out.println("Enter y/n");
                                String yn = sc.next();
                                if (yn.equals("n")) {
                                    System.exit(0);
                                }
                            } else if (ch == 2) {
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

                                System.out.println("Would you still like to continue?");
                                System.out.println("Enter y/n");
                                String yn = sc.next();
                                sc.nextLine();
                                if (yn.equals("n")) {
                                    System.exit(0);


                                }

                            } else if (ch == 3) {
                                System.out.println("Here is your bank balance" + b.getBankBalance());
                                System.out.println("Other account details:");
                                System.out.println("Name:" + " " + b.getName());
                                System.out.println("Address:" + " " + b.getAddress());
                                System.out.println("Email:" + " " + b.getEmail());
                                System.out.println("Contact number:" + " " + b.getMobileNumber());
                                System.out.println("SIN:" + " " + b.getSin());
                                System.out.println("Would you still like to continue?");
                                System.out.println("Enter y/n");
                                String yn = sc.next();
                                sc.nextLine();
                                if (yn.equals("n")) {
                                    System.exit(0);

                                }


                            } else if (ch == 4) {
                                myList.delAccount(b);
                                System.out.println("Account deleted");
                                //break;
                                System.exit(0);
                            }
                        }
                    } else {
                        num -= 1;
                        if (num == 0) {
                            System.out.println("Account does not exist.Please restart the "
                                    + "system and create your new account");
                            System.exit(0);
                        }


                    }


                }


            }
        }


    }
}







