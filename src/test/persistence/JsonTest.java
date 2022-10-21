package persistence;

import model.BankAccount;

import model.ListBankAccounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkAcc(String email, String password, String name, String address, String mobileNumber,
                            String sin,double bankBalance, BankAccount acc) {
        assertEquals(name, acc.getName());
        assertEquals(email, acc.getEmail());
        assertEquals(password, acc.getPassword());
        assertEquals(sin, acc.getSin());
        assertEquals(address, acc.getAddress());
        assertEquals(bankBalance, acc.getBankBalance());
        assertEquals(mobileNumber, acc.getMobileNumber());
    }
}