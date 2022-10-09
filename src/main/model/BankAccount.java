package model;

//Represents a bank account having details like email address,password,name of the account holder,residential address,
//mobile number,Social Insurance Number,and the bank balance of the account
public class BankAccount {
    private String email;
    private String password;
    private String name;
    private String address;
    private String mobileNumber;
    private String sin;
    private double bankBalance;

    // EFFECTS: constructs a bank account with email,password,name,address,mobile number, sin  with zero
    // bank account balance
    public BankAccount(String email, String password, String name, String address, String mobileNumber, String sin) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.sin = sin;
        this.bankBalance = 0;
    }
    //REQUIRES : amount >0
    //MODIFIES: this
    // EFFECTS: increments the bank balance by amount(in dollars)


    public void deposit(double amount) {
        this.bankBalance += amount;
    }

    //REQUIRES : amount >0 and amount <= getBankBalance()
    //MODIFIES: this
    // EFFECTS: decrements the bank balance by amount(in dollars)
    public void withdraw(double amount) {
        this.bankBalance -= amount;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getSin() {
        return this.sin;
    }

    public double getBankBalance() {
        return this.bankBalance;
    }

    public String getPassword() {
        return this.password;
    }
}
