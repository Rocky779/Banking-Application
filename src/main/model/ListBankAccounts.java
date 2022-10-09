package model;

import java.util.ArrayList;

//A list containing many instances of BankAccount

public class ListBankAccounts {
    ArrayList<BankAccount> myBank;

    //EFFECTS: Creates an empty list of BankAccount

    public ListBankAccounts() {
        myBank = new ArrayList<BankAccount>();

    }

    //MODIFIES: this
    //EFFECTS: ADDS A BANK ACCOUNT TO THE LIST
    public void addAccount(BankAccount acc) {
        myBank.add(acc);
    }

    //MODIFIES: this
    //EFFECTS: Remove a bank account from the list
    public void delAccount(BankAccount acc) {
        myBank.remove(acc);
    }

    //EFFECTS: Returns size of the list
    public int getSize() {
        return myBank.size();
    }

    //EFFECTS: Returns the list of bank accounts
    public ArrayList<BankAccount> returnList() {
        return myBank;
    }

}



