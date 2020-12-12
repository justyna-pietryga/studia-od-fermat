import java.math.BigInteger;

public class HandleFermat {

    public static BigInteger generateOddRandomNumber(String maxVal) throws Exception {

        BigInteger max = new BigInteger(maxVal);
        BigInteger min = BigInteger.ZERO; // lower limit

        if (max.compareTo(BigInteger.valueOf(10).pow(9)) < 0) {
            throw new Exception("Number is not greater than 10^9");
        }

        BigInteger result = Utils.generateRandomNumberLowerThanTestesOne(max, min);

        return !result.mod(BigInteger.TWO).equals(BigInteger.ZERO) ? result : result.add(BigInteger.valueOf(1));
    }
}
