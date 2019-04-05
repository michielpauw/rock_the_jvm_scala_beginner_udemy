package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
  person.greet()
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  // val and var definitions, function definitions (methods), expressions.

  // val and var definitions are actual fields.
  // At the instantiation of an object, the entire body will be evaluated and expressions will be executed.

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // this.name is implied when there is no ambiguity (because of a method with the same parameter name)

  // overloading: defining different methods with the same name and different signatures
  // (and possibly different return types)
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple/overloading constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
  // the only implementation that an auxiliary constructor can have: it calls another constructor. Often it is more
  // easily solved by adding default parameters.
}

// A class parameter is not a class member: it cannot be accessed with the . operator.

// You can access a parameter if you add 'val' of 'var' keyword to the parameter.