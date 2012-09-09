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
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            if (isElfProof(sb.toString())) {
                return sb.toString();
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        throw new RuntimeException("WTF?");
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
