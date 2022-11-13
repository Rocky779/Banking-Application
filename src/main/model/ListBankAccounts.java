package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//A list containing many instances of BankAccount

public class ListBankAccounts implements Writable {
    ArrayList<BankAccount> myBank;
    String name;

    //EFFECTS: Creates an empty list of BankAccount

    public ListBankAccounts(String name) {
        myBank = new ArrayList<>();
        this.name = name;

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

    public String returnName() {
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("myBank", thingiesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (BankAccount t : myBank) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    public String descriptionAcc() {
        String listings = "";
        for (int i = 0; i < myBank.size(); i++) {
            listings += "Account Number" + i + "\n" + "Email" + myBank.get(i).getEmail()
                    + "\n" + "Password" + myBank.get(i).getPassword() + "\n"
                    + "Name" + myBank.get(i).getName() + "\n" + "Address" + myBank.get(i).getAddress() + "\n"
                    + "Mobile number" + myBank.get(i).getMobileNumber() + "\n" + "SIN" + myBank.get(i).getSin() + "\n"
                    + "Bank balance" + myBank.get(i).getBankBalance() + "\n" + "\n";
        }
        return listings;
    }

}



