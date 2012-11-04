package RandomIdProvider.Entities

import junit.framework.{TestCase, TestSuite, Test}
import junit.framework.Assert._
import org.junit
import junit.runner.RunWith

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers


import util.Random
import scalax.logging.Logging
import RandomIdProvider.generator.BSNGenerator


/**
 * Unit test for simple App.
 */
@RunWith(classOf[JUnitRunner])
class BSNGeneratorTest extends FlatSpec with ShouldMatchers {


  "The BSNGenerator" should "generate 100 correct numbers" in {
    val bsnGenerator = new BSNGenerator(new Random(0))
    for (i <- 0 to 100) {
      val bsn = bsnGenerator.getBsn
      bsnGenerator.isElfProof(bsn) should equal (true)
    }

  }

  it should "validate a correct bsn number" in {
    val bsnGenerator = new BSNGenerator()
    bsnGenerator.isElfProof("73.61.60.221") should equal (true)
  }

  it should "not validate a swap" in {
    val bsnGenerator = new BSNGenerator()
    bsnGenerator.isElfProof("73.16.60.221") should equal (false)
  }

  it should "not validate a wrong number" in {
    val bsnGenerator = new BSNGenerator()
    bsnGenerator.isElfProof("73.62.60.221") equals (false)
  }

}
