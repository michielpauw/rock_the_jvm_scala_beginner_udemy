package lectures.part3fp

object AnonymousFunctions extends App {

  val doublerLong = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  }

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2
  val doubler2: Int => Int = (x: Int) => x * 2
  val doubler3: Int => Int = x => x * 2

  // multiple parameters in a lambda
  val adder = (a: Int, b: Int) => a + b
  val adder2: (Int, Int) => Int = (a, b) => a + b

  // no params
  val justDoSomething = () => 3
  val justDoSomething2: () => Int = () => 3

  println(justDoSomething)
  println(justDoSomething()) // LAMBDAS MUST BE CALLED WITH PARANTHESES

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer2: Int => Int = _ + 1 // equivalent to x => x + 1

  val niceAdder: (Int, Int) => Int = (a, b) => a + b
  val niceAdder2: (Int, Int) => Int = _ + _ // each underscore stands for a different parameter
}
