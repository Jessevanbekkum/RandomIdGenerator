package RandomIdProvider.generator

import io.Source
import scala.util.Random

class RandomParameterReader(val file: Source, val random: Random) extends Generator[String] {

  def this(file: Source) = this(file, new Random)

  class Name(val name: String, val prob: Double) {
    sum += prob
    var cumulative = sum

    override def toString = name
  }

  private var sum = 0.0: Double

  val buf = scala.collection.mutable.ListBuffer.empty[Name]
  val lines = file.getLines()
  lines.foreach(createAndPut(_))
  val names = buf.toList
  normalize()

  def createAndPut(line: String) {
    val fields = line.split(";")

    buf += parseLine(fields)
  }

  def parseLine(fields: Array[String]): Name = {
    if (fields.length == 1)
      new Name(fields(0), 1)
    else
      new Name(fields(0), fields(1).toDouble)
  }

  def normalize() {
    val factor = 1 / sum
    names.foreach(_.cumulative *= factor)
  }


  def getOne: String = {
    val r = random.nextDouble()
    val index = names.indexWhere(r < _.cumulative)
    names(index).name
  }


}
