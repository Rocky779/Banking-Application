package persistence;

import model.BankAccount;

import model.ListBankAccounts;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListBankAccounts wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            ListBankAccounts wr = reader.read();
            assertEquals("My Bank Account", wr.returnName());
            assertEquals(0, wr.returnList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            ListBankAccounts wr = reader.read();
            assertEquals("My Bank Account", wr.returnName());
            List<BankAccount> accounts = wr.returnList();
            assertEquals(2, accounts.size());
            checkAcc("123@gmail.com","123456","Rocky","1755 Street",
                    "12345678","1234567890",900,accounts.get(0));
            checkAcc("1234@gmail.com","1234567","Robert","1705 Street",
                    "12345670","1234567898",9000,accounts.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}