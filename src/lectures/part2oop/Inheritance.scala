package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "Wild"
    // private: only accessible in this class, protected: accessible in children
    // protected def eat = println("Nomnom")
    def eat = println("Nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("Crunch crunch")
    }
  }

  val cat = new Cat
  // can't call cat.eat
  cat.crunch

  // constructors
  class Person(name: String, age: Int)
  // class Adult(name: String, age: Int, idCard: String) extends Person --> won't compile
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
  //  override val creatureType = "Domestic"
    override def eat = {
      super.eat
      println("Crunch crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad sense: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // distinction between overriding vs overloading

  // super

  // Preventing overrides:
  // 1. Use keyword final on member
  // 2. Use final on class
  // 3. Seal the class = extend classes in THIS FILE ONLY, prevent extending in other files.
}
