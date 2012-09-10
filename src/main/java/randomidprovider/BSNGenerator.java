package randomidprovider;

import java.util.Random;

/**
 *
 */
public class BSNGenerator {
    Random random;

    BSNGenerator(long seed) {
        random = new Random(seed);
    }

    BSNGenerator() {
        random = new Random();
    }

    public String getBsn() {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int nextInt = random.nextInt(10);
            sb.append(nextInt);
            sum += (9 - i) * nextInt;
        }

        int remainder = sum % 11;
        if (remainder == 1) {
            return getBsn();
        }

        sb.append((11 - remainder) % 11);
        return sb.toString();
    }

    public boolean isElfProof(String bsn) {

        String cleanBsn = clearNonDigits(bsn);
        int sum = 0;

        for (int i = 0; i < cleanBsn.length(); i++) {
            char c = cleanBsn.charAt(i);

            sum += (cleanBsn.length() - i) * Character.digit(c, 10);
        }


        return sum % 11 == 0 && sum > 0;
    }

    public boolean isBsnNumber(String bsn) {
        String cleanBsn = clearNonDigits(bsn);
        int sum = 0;

        for (int i = 0; i < cleanBsn.length() - 1; i++) {
            char c = cleanBsn.charAt(i);

            sum += (cleanBsn.length() - i) * Character.digit(c, 10);
        }


        return sum % 11 == 0 && sum > 0;
    }

    private String clearNonDigits(String s) {
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        while (i != sb.length()) {
            if (Character.isDigit(sb.charAt(i))) {
                i++;
            } else {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
}
