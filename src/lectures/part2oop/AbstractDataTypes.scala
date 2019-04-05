package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract members
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  // override keyword is not mandatory for abstract members
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("Crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "Croc"
    val eat: Unit = println("Nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  /*
    Traits vs abstract classes:
    Both can have abstract AND none abstract members.
    1. Traits do not have constructor parameters
    2. You can only extend one class, but multiple traits may be inherited
    3. traits are behavior, an abstract class is a type of thing.
   */
}
