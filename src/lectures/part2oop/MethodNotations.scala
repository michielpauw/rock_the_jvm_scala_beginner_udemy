package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}."
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}."
    def unary_! : String = s"$name, what the heck!?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation --> only works for methods with a single parameter
  // Syntactic sugar

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  // We can actually call the function '+' and it will still work!!
  println(mary + tom)
  println(mary.+(tom))

  // As a matter of fact:
  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)
  // Not used often. Only available to methods without parameters.

  // apply
  println(mary.apply())
  println(mary()) //equivalent
}
