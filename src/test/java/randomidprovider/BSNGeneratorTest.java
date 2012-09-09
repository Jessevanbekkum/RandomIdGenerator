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
        BSNGenerator bsnGenerator = new BSNGenerator();

        for (int i =0; i<100;i++) {
            assertThat(bsnGenerator.isElfProof(bsnGenerator.getBsn()), is(true));
        }
    }

    @Test
    public void testIsElfProof() {
        BSNGenerator bsnGenerator = new BSNGenerator();
        assertThat(bsnGenerator.isElfProof("73.61.60.221"), is(true));
    }
}
