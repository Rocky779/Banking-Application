package persistence;


import model.ListBankAccounts;

import model.BankAccount;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads List from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListBankAccounts read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListBankAccount(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }
    // EFFECTS: parses listOfBankAccount from JSON object and returns it

    private ListBankAccounts parseListBankAccount(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ListBankAccounts wr = new ListBankAccounts(name);
        addBankAccounts(wr, jsonObject);
        return wr;
    }


    // MODIFIES: wr
    // EFFECTS: parses accounts from JSON object and adds them to listOfBankAccounts
    private void addBankAccounts(ListBankAccounts wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("myBank");
        for (Object json : jsonArray) {
            JSONObject nextAcc = (JSONObject) json;
            addBankAccount(wr, nextAcc);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses Acc from JSON object and adds it to ListOfBankAccounts
    private void addBankAccount(ListBankAccounts wr, JSONObject jsonObject) {
        String email = jsonObject.getString("email");
        String password = jsonObject.getString("password");
        String name = jsonObject.getString("name");
        String address = jsonObject.getString("address");
        String mobileNumber = jsonObject.getString("mobile number");
        String sin = jsonObject.getString("sin");
        double bankBalance = jsonObject.getDouble("bank balance");


        BankAccount acc = new BankAccount(email, password, name, address, mobileNumber, sin, bankBalance);
        wr.addAccount(acc);
    }
}

