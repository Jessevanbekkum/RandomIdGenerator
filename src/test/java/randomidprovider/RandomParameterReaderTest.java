package randomidprovider;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
            bos.write("Jan\nPiet\nKlaas");
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
            RandomParameterReader rpr = new RandomParameterReader(f, 0);
            System.out.println(rpr.getOne());
            System.out.println(rpr.getOne());
            rpr.getOne();
        } catch (IOException e) {
            fail();
        }
    }

}
