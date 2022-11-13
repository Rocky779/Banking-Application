import model.BankAccount;

import model.ListBankAccounts;

import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankListTest {
    private ListBankAccounts testList;
    private ArrayList<BankAccount> arrayList;
    private BankAccount a;
    private BankAccount b;

    @BeforeEach
    void runBefore() {
        testList = new ListBankAccounts("Bank1");
        b = new BankAccount("rsa@gmail.com", "123456", "Robert", "1755 Park Lane",
                "6057899009", "123456789", 0);
        arrayList = new ArrayList<>();
        a = new BankAccount("rsa4@gmail.com", "123456", "Tom", "1745 Park Lane",
                "6057890009", "193456789", 0);
    }

    @Test
    void testConstructor() {
        assertEquals(testList.returnList(), arrayList);
    }

    @Test
    void testAddAcc() {
        assertEquals(testList.returnList().add(b), arrayList.add(b));


    }

    @Test
    void testAddAcc2() {
        testList.addAccount(a);
        testList.addAccount(b);
        arrayList.add(a);
        arrayList.add(b);
        assertEquals(testList.returnList(), arrayList);
    }

    @Test
    void testDelAcc() {
        testList.addAccount(b);
        testList.delAccount(b);
        assertEquals(testList.returnList(), arrayList);
    }

    @Test
    void testDelAcc2() {
        testList.addAccount(b);
        testList.addAccount(a);
        testList.delAccount(a);
        arrayList.add(b);
        assertEquals(testList.returnList(), arrayList);
    }

    @Test
    void testDelAcc3() {
        testList.addAccount(b);
        testList.addAccount(a);
        testList.delAccount(b);
        testList.delAccount(a);
        assertEquals(testList.returnList(), arrayList);
    }

    @Test
    void testGetSize() {
        testList.addAccount(a);
        assertEquals(1, testList.getSize());
    }

    @Test
    void testGetSize2() {
        assertEquals(0, testList.getSize());

    }

    @Test
    void testReturnList() {
        assertEquals(testList.returnList(), arrayList);
    }

    @Test
    void testReturnList2() {
        testList.addAccount(a);
        arrayList.add(a);
        assertEquals(testList.returnList(), arrayList);
    }

    @Test
    void displayTest() {
        testList.addAccount(a);
        assertEquals("Account Number" + "0" + "\n" + "Email" + a.getEmail()
                + "\n" + "Password" + a.getPassword() + "\n"
                + "Name" + a.getName() + "\n" + "Address" + a.getAddress() + "\n"
                + "Mobile number" + a.getMobileNumber() + "\n" + "SIN" + a.getSin() + "\n"
                + "Bank balance" + a.getBankBalance() + "\n" + "\n", testList.descriptionAcc());

    }

}
