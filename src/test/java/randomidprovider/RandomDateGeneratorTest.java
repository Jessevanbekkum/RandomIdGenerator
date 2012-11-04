package randomidprovider;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class RandomDateGeneratorTest {

    @Test
    public void testScala() {
        RandomDateGeneratorImpl rd = new RandomDateGeneratorImpl();
        Date d = rd.getDate();
        assertThat(d.getTime() > 3, is(true)) ;
    }


}
