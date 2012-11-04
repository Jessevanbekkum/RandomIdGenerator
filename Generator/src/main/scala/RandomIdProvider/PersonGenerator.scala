package RandomIdProvider

import Entities.Person
import generator.{RandomDateGenerator, Generator}

/**
 * 
 */
class PersonGenerator(val firstNameGenerator: Generator[String], val lastNameGenerator: Generator[String]) extends Generator[Person]{
var dateGenerator = new RandomDateGenerator() : RandomDateGenerator

def getOne = {
  val person = new Person
  person.firstName = firstNameGenerator.getOne
  person.lastName = lastNameGenerator.getOne

  if (dateGenerator != null) {
    person.dateOfBirth = dateGenerator.getOne.getTime
  }

  person
}

}