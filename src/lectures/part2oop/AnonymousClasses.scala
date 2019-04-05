package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("HAHAHAHAHA")
  }
  /* EQUIVALENT WITH:

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("HAHAHAHAHA")
    }
   */

  println(funnyAnimal.getClass)
  // class lectures.part2oop.AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  // Pass in the proper parameters!!
  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi, my name is Jim, how can I be of service?")
  }

  // Anonymous classes work for both abstract and non abstract data types
}
