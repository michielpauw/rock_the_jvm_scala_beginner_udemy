package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY (no "static")
  object Person { // type + its only instance
    // "static"/"class"-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method (sole purpose is building persons given some parameters)
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    // regularly they are called apply :o!
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  // COMPANIONS (same scope and same name for class and object)
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object is a SINGLETON INSTANCE

    val mary_2 = Person
    val john_2 = Person
    println(mary_2 == john_2)

    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    // val bobbie = Person.from(mary, john)
    // This looks like a constructor, but is actually the apply method in the Person singleton object
    val bobbie = Person(mary, john)

    // Scala applications = Scala object with
    // def main(args: Array(String)): Unit
  }
}
