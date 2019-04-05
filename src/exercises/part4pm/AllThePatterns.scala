package exercises.part4pm

object AllThePatterns extends App {

  val numbers = List(1, 2, 3)

  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch)

  // WHY?
  // JVM trick question

}
