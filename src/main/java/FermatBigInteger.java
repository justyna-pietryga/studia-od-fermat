import java.math.BigInteger;

public class FermatBigInteger {
    private BigInteger testedNumber;
    private int numberOfTries;

    public FermatBigInteger(String testedNumber, int numberOfTries) {
        setTestedNumber(testedNumber);
        this.numberOfTries = numberOfTries;
    }

    public void setTestedNumber(String number) {
        if (isStringNumber(number)) {
            this.testedNumber = new BigInteger(number);
        } else {
            throw new RuntimeException("Text is not a number");
        }
    }

    public void setNumberOfTries(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    private boolean isStringNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) return false;
        }
        return true;
    }

    public boolean isPrimeNumber() {
        for (int i = 0; i < numberOfTries; i++) {
            BigInteger a = generateRandomNumberLowerThanTestesOne();
            if (Utils.calculateNwd(a, testedNumber).compareTo(BigInteger.ONE) > 0) return false;
            if (!a.modPow(testedNumber.subtract(BigInteger.ONE), testedNumber).equals(BigInteger.ONE))
                return false;
        }

        return true;
    }

    private BigInteger generateRandomNumberLowerThanTestesOne() {
        BigInteger max = testedNumber.subtract(BigInteger.valueOf(1L));// uper limit
        BigInteger min = new BigInteger("2");// lower limit

        return Utils.generateRandomNumberLowerThanTestesOne(max, min);
    }
}
