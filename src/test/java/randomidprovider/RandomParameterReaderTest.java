package randomidprovider;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.fail;

/**
 *
 */
public class RandomParameterReaderTest {

    private File generatePlainFile() {

        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println(tempDir);
        File f = new File(tempDir, "names.txt");
        f.deleteOnExit();
        try {
            BufferedWriter bos = new BufferedWriter(new FileWriter(f));
            bos.write("Jan;0.25\nPiet;0.5\nKlaas;0.25");
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return f;
    }

    @Test
    public void GenerateNames() {
        try {
            File f = generatePlainFile();
            RandomParameterReader rpr = new RandomParameterReader(f, new Random(0));
            for (int i = 0; i < 20; i++) {
                System.out.println(rpr.getOne());
            }
        } catch (IOException e) {
            fail();
        }
    }

}
