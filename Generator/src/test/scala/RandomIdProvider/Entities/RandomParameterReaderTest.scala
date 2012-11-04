package RandomIdProvider.Entities

import junit.framework.{TestCase, TestSuite, Test}
import junit.framework.Assert._
import java.io._
import util.Random
import io.{BufferedSource, Codec, Source}
import scalax.io._
import RandomIdProvider.generator.RandomParameterReader

/**
 *
 */
object RandomParameterReaderTest {

  def suite: Test = {
    val suite = new TestSuite(classOf[RandomDateGeneratorTest]);
    suite
  }

  def main(args: Array[String]) {
    junit.textui.TestRunner.run(suite);
  }
}

/**
 * Unit test for simple App.
 */
class RandomParameterReaderTest extends TestCase("app") {

  /**
   * Rigourous Tests :-)
   */

  def generatePlainFile(): File = {
    val tempDir = System.getProperty("java.io.tmpdir");

    val f = new File(tempDir, "names.txt") :File
    f.deleteOnExit();

    val out = new PrintWriter(f)
    out.write("Jan;0.25\nPiet;0.5\nKlaas;0.25")
    out.close()

    f;
  }

  def generatePlainFileWithoutProbs: File = {
    val tempDir = System.getProperty("java.io.tmpdir");

    val f = new File(tempDir, "names.txt") :File
    f.deleteOnExit();

    val out = new PrintWriter(f)
    out.write("Jan\nPiet\nKlaas")
    out.close()

    f;
  }

  def testGenerateNames() {
      val f = generatePlainFile()
      val s =  Source.fromFile(f)
      val rpr = new RandomParameterReader(s, new Random(0));
      assertEquals(rpr.getOne,"Piet")
      assertEquals(rpr.getOne,"Jan")


  }

  def testGenerateNamesWithoutProbs() {
    val f = generatePlainFileWithoutProbs
    val s =  Source.fromFile(f)
    val rpr = new RandomParameterReader(s, new Random(0));
    assertEquals(rpr.getOne,"Klaas")
    assertEquals(rpr.getOne,"Jan")


  }
}
