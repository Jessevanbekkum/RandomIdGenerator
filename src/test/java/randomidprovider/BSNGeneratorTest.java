package randomidprovider;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class BSNGeneratorTest {
    @Test
    public void testGetBsn() throws Exception {
        BSNGenerator bsnGenerator = new BSNGenerator(0);

        for (int i =0; i<100;i++) {
            String bsn = bsnGenerator.getBsn();
            System.out.println(bsn);
            assertThat(bsnGenerator.isElfProof(bsn), is(true));
        }
    }

    @Test
    public void testIsElfProof() {
        BSNGenerator bsnGenerator = new BSNGenerator();
        assertThat(bsnGenerator.isElfProof("73.61.60.221"), is(true));
    }

    @Test
    public void testSwapIsNotElfProof() {
        BSNGenerator bsnGenerator = new BSNGenerator();
        assertThat(bsnGenerator.isElfProof("73.16.60.221"), is(false));
    }

    @Test
    public void wrongNumberIsNotElfProof() {
        BSNGenerator bsnGenerator = new BSNGenerator();
        assertThat(bsnGenerator.isElfProof("73.62.60.221"), is(false));
    }
}
