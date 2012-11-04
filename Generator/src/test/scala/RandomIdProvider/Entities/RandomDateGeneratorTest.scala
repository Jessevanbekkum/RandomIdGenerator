package RandomIdProvider.Entities

import junit.framework.{TestCase, TestSuite, Test}
import junit.framework.Assert._
import util.Random
import java.util.GregorianCalendar
import RandomIdProvider.generator.RandomDateGenerator

/**
 *
 */
object RandomDateGeneratorTest {

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
class RandomDateGeneratorTest extends TestCase("app") {


  def testGetDate() {
    val begin = new GregorianCalendar(1984, 1, 1)
    val end = new GregorianCalendar(1985, 1, 1)

    val rdg = new RandomDateGenerator(begin.getTime, end.getTime, new Random(0))
    val date = rdg.getOne
    println(date)
    println(begin)
    assertTrue(begin.before(date))
    assertTrue(end.after(date))

  }

}
