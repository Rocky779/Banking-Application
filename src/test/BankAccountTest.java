import model.BankAccount;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount testAcc;

    @BeforeEach
    void runBefore() {
        testAcc = new BankAccount("rsa@gmail.com", "123456", "Robert", "1755 Park Lane",
                "6057899009", "123456789");

    }

    @Test
    void testConstructor() {
        assertEquals("rsa@gmail.com", testAcc.getEmail());
        assertEquals("123456", testAcc.getPassword());
        assertEquals("Robert", testAcc.getName());
        assertEquals("1755 Park Lane", testAcc.getAddress());
        assertEquals("6057899009", testAcc.getMobileNumber());
        assertEquals("123456789", testAcc.getSin());
    }

    @Test
    void testDeposit() {
        testAcc.deposit(500);
        assertEquals(500, testAcc.getBankBalance());
    }

    @Test
    void testDeposit2() {
        testAcc.deposit(500.8);
        testAcc.deposit(1000);
        assertEquals(1500.8, testAcc.getBankBalance());

    }

    @Test
    void testWithdraw() {
        testAcc.deposit(400);
        testAcc.withdraw(200);
        assertEquals(200, testAcc.getBankBalance());
    }

    @Test
    void testWithdraw2() {
        testAcc.deposit(400);
        testAcc.withdraw(400);
        assertEquals(0, testAcc.getBankBalance());
    }

    @Test
    void testWithdrawMultiple() {
        testAcc.deposit(800);
        testAcc.withdraw(400);
        testAcc.withdraw(100.5);
        assertEquals(299.5, testAcc.getBankBalance());
    }


}
