package persistence;

import model.ListBankAccounts;
import model.BankAccount;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {


    @Test
    void testWriterInvalidFile() {
        try {
            ListBankAccounts wr = new ListBankAccounts("My workspace");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            ListBankAccounts wr = new ListBankAccounts("My Bank Account");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            wr = reader.read();
            assertEquals("My Bank Account", wr.returnName());
            assertEquals(0, wr.returnList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            ListBankAccounts wr = new ListBankAccounts("My Bank Account");
            wr.addAccount(new BankAccount("123@gmail.com", "123456", "Rocky", "1755 Street",
                    "12345678", "1234567890", 900));
            wr.addAccount(new BankAccount("1234@gmail.com", "1234567", "Robert", "1705 Street",
                    "12345670", "1234567898", 9000));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            wr = reader.read();
            assertEquals("My Bank Account", wr.returnName());
            List<BankAccount> thingies = wr.returnList();
            assertEquals(2, wr.returnList().size());
            checkAcc("123@gmail.com", "123456", "Rocky", "1755 Street",
                    "12345678", "1234567890", 900, thingies.get(0));
            checkAcc("1234@gmail.com", "1234567", "Robert", "1705 Street",
                    "12345670", "1234567898", 9000, thingies.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

