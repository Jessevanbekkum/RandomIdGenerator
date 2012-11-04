package randomidprovider

import java.util.{Date, Random}

/**
 *
 */
class RandomDateGeneratorImpl extends RandomDateGenerator {
  var random: Random

  def getDate:Date = new Date(random.nextLong())

}
