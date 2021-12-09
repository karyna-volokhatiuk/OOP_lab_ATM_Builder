package atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ATMTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ATM atm;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        atm = new ATM();
    }

    @Test
    void testProcessCorrectInput() {
        atm.process(125);
        assertEquals("Please, receive 1 of 5UAN bills\n" +
                "Please, receive 0 of 10UAN bills\n" +
                "Please, receive 6 of 20UAN bills\n", outContent.toString());
    }

    @Test()
    void testProcessIncorrectInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> atm.process(126));
        assertEquals("We don't have needed bills.", thrown.getMessage());
    }

}