package RandomIdProvider.generator

import util.Random

/**
 *
 */
class BSNGenerator(val random: Random) {
  def this() = this(new Random())

  def getBsn: String = {
    val sb = new StringBuilder
    var sum = 0
    for (i <- 0 until 8) {
      val nextInt = random.nextInt(10): Int
      sb.append(nextInt)
      sum += (9 - i) * nextInt
    }

    val remainder = sum % 11
    if (remainder == 1) {
       getBsn
    }
    else {
      sb.append((11 - remainder) % 11)
      sb.toString
    }
  }

  def isElfProof(bsn: String): Boolean = {
    val cleanBsn = clearNonDigits(bsn)
    var sum = 0

    for (i <- 0 until cleanBsn.length()) {
      val c = cleanBsn.charAt(i)
      sum += (cleanBsn.length() - i) * Character.digit(c, 10)
    }
    sum % 11 == 0 && sum > 0
  }

  def isBsnNumber(bsn: String): Boolean = {
    val cleanBsn = clearNonDigits(bsn)
    var sum = 0

    for (i <- 0 until cleanBsn.length()) {
      val c = cleanBsn.charAt(i)

      sum += (cleanBsn.length() - i) * Character.digit(c, 10)
    }

    sum % 11 == 0 && sum > 0
  }

  def clearNonDigits(s: String): String = {
    val sb = new StringBuilder(s)
    var i = 0
    while (i != sb.length()) {
      if (Character.isDigit(sb.charAt(i))) {
        i += 1
      } else {
        sb.deleteCharAt(i)
      }
    }
    sb.toString()
  }
}
