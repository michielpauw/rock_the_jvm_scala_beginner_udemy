package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => 42 // _ = WILDCARD
  }
  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US."
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "I don't know who I am"
  }

  print(greeting)

  /*
    1. cases are matched in order
    2. what if no cases match? MatchError
    3. type of the PM expression? The compiler will try to unify types, it will return lowest common ancestor
    4. PM works really well with case classes
   */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

//  val animal: Animal = Dog("Terra Nova")
//  animal match {
//    case Dog (someBreed) => println(s"Matched a dog of the $someBreed breed.")
//  }
  // ^^ Will return a warning: match may not be exhaustive because Animal is a sealed class. So sealed classes help
  // you cover your ass.

  // don't match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  // WHY?!

  val isEvenCond = if (x % 2 == 0) true else false // ?!
  val isEvenNormal = x % 2 == 0
}
