package randomidprovider;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 *
 */
public class RandomParameterReaderTest {

    private File generatePlainFile() {

        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println(tempDir);
        File f= new File(tempDir, "names.txt");
        f.deleteOnExit();
        try {
            BufferedWriter bos = new BufferedWriter(new FileWriter(f));
            for (int i = 0;i<100;i++) {
                bos.write("Naam" + i);
                bos.newLine();
            }
          bos.flush();
            bos.close();
        }  catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return f;
    }

    @Test
    public void GenerateNames() {
        try {
            File f = generatePlainFile();
            RandomParameterReader rpr = new RandomParameterReader(f, new Random(0));
            for (int i =0;i<19;i++) {
               rpr.getOne();
            }

            assertThat(rpr.getOne(), is("Naam77"));
        } catch (IOException e) {
            fail();
        }
    }

}
