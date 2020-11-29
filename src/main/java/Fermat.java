import java.math.BigInteger;

public class Fermat {
    public final long testedNumber;
    public final BigInteger tested2;
    public final int numberOfTries;
    private final long randomNumberMax;
    private final static int randomNumberMin = 2;

    public Fermat(long testedNumber, int numberOfTries) {
        this.testedNumber = testedNumber;
        this.numberOfTries = numberOfTries;
        this.randomNumberMax = testedNumber - 1;
        this.tested2 = BigInteger.valueOf(testedNumber);
    }

    public boolean isPrimeNumber() {
        for (int i = 0; i < numberOfTries; i++) {
            long a = generateRandomNumberLowerThanTestesOne();
            if (powerModulo(a, testedNumber - 1, testedNumber) != 1) return false;
        }

        return true;
    }

    private long powerModulo(long a, long b, long m) {
        long result = 1;
        long x = a % m;

        for (long i = 1; i <= b; i <<= 1) {
            x %= m;
            if ((b & i) != 0) {
                result *= x;
                result %= m;
            }
            x *= x;
        }

        return result % m;
    }

    private long generateRandomNumberLowerThanTestesOne() {
        return (long) (Math.random() * (randomNumberMax - randomNumberMin + 1)) + randomNumberMin;
    }
}
