package atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DefaultBillTest {
    Bill bill, nextBill;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        bill = new DefaultBill(5);
        nextBill = new DefaultBill(2);
        bill.setNext(nextBill);
    }

    @Test
    void setNext() {
        assertEquals(nextBill, bill.getNextBill());
    }


    @Test
    void testProcessCorrectInput() {
        bill.process(12);
        assertEquals("Please, receive 1 of 2UAN bills\r\n" +
                "Please, receive 2 of 5UAN bills\r\n",
                outContent.toString());
    }

    @Test()
    void testProcessIncorrectInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> bill.process(11));
        assertEquals("We don't have needed bills.", thrown.getMessage());
    }
}