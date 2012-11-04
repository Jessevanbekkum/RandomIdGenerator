package RandomIdProvider.generator

import java.util.{Calendar, GregorianCalendar, Date}
import util.Random

/**
 *
 */
class RandomDateGenerator(val begin: Date, val end: Date, val random: Random) extends Generator[Calendar]{
  def this(begin: Date, end: Date) = this(begin, end, new Random)
  def this() = this(new GregorianCalendar(1912,1,1,0,0,0).getTime, new Date(), new Random)

  if (end.before(begin)) {
    throw new RuntimeException("Begin date must be before end date")
  }

  val beginL = begin.getTime
  val endL = end.getTime


  def getOne: Calendar = {
    val date = new Date(beginL + math.abs(random.nextLong()) % (endL - beginL))
    val cal = new GregorianCalendar()
    cal.setTimeInMillis(date.getTime)
    cal
  }
}
