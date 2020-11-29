import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FermatTest {

    @Test
    public void isPrimeNumberTest() {
        FermatBigInteger fermatBigInteger = new FermatBigInteger("7919", 10);
        assertTrue(fermatBigInteger.isPrimeNumber());

        testIsPrime(fermatBigInteger, "187631", 10);
        testIsPrime(fermatBigInteger, "185291", 10);
        testIsPrime(fermatBigInteger, "206179", 10);
        testIsPrime(fermatBigInteger, "15485863", 20);
        testIsPrime(fermatBigInteger, "122949823", 50);
        testIsPrime(fermatBigInteger, "275604541", 50);
        testIsPrime(fermatBigInteger, "982451653", 50);
        testIsPrime(fermatBigInteger, "961748927", 50);
    }

    private void testIsPrime(FermatBigInteger fermatBigInteger, String number, int amountOfTries) {
        fermatBigInteger.setTestedNumber(number);
        fermatBigInteger.setNumberOfTries(amountOfTries);
        assertTrue(fermatBigInteger.isPrimeNumber());
    }

    @Test
    public void isNotPrimeNumberTest() {
        FermatBigInteger fermatBigInteger = new FermatBigInteger("0", 0);
        testIsNotPrime(fermatBigInteger, "1000000000000", 20);
        testIsNotPrime(fermatBigInteger, "1000000000000000", 50);
        testIsNotPrime(fermatBigInteger, "10000000000000000", 50);
        testIsNotPrime(fermatBigInteger, "1000000000000000000", 50);
        testIsNotPrime(fermatBigInteger, "100000000000000000000000", 50);
        testIsNotPrime(fermatBigInteger, "10000000000000000000000000000", 50);
        testIsNotPrime(fermatBigInteger, "1000000000000000000000000000000000000", 50);
        testIsNotPrime(fermatBigInteger, "100000000000000000000000000000000000000000000000", 50);
    }

    private void testIsNotPrime(FermatBigInteger fermatBigInteger, String number, int amountOfTries) {
        fermatBigInteger.setTestedNumber(number);
        fermatBigInteger.setNumberOfTries(amountOfTries);
        assertFalse(fermatBigInteger.isPrimeNumber());
    }
}