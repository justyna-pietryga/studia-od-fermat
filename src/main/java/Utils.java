import java.math.BigInteger;
import java.util.Random;

public class Utils {
    public static BigInteger generateRandomNumberLowerThanTestesOne(BigInteger upperLimit, BigInteger lowerLimit) {
        BigInteger rangeBigInt = upperLimit.subtract(lowerLimit);
        Random random = new Random();
        int maxNumBitLength = upperLimit.bitLength();

        BigInteger result;

        result = new BigInteger(maxNumBitLength, random);
        if (result.compareTo(lowerLimit) < 0)
            result = result.add(lowerLimit);
        if (result.compareTo(upperLimit) >= 0)
            result = result.mod(rangeBigInt).add(lowerLimit);

        return result;
    }

    public static BigInteger calculateNwd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        } else {
            return calculateNwd(b, a.mod(b));
        }
    }
}
