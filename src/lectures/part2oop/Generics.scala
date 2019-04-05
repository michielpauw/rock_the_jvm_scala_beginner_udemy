package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use type A inside class definition
    // def add(element: A): MyList[A] = ???
    // If I add to MyList a superclass of A, create new MyList of B, instead of A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = (Dog = )Animal
     */
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key, Value]

  // traits can also be type parameterized

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Does a list of Cat extend a list of Animal? Three possible answers:
  // 1. Yes: List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog)??? HARD QUESTION => We return a list of animals.

  // 2. No = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell no = CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types

  // upper bounded types:
  class Cage[A  <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car)

  // >: means it only accepts supertypes of Animal


}
