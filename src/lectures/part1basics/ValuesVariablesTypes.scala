package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x = 42
  // val x: Int = 42
  // val x: Int = "" WON'T WORK
  println(x)

  // VALS ARE IMMUTABLE
  // TYPES OF VALS ARE OPTIONAL
  // COMPILER CAN INFER TYPES

  val aString: String = "hello"
  val anotherString: String = "goodbye"

  // SEMICOLONS ARE ALLOWED BUT NOT NECESSARY (except if you write multiple expressions per line)

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 324234234234324L
  // SHORT IS REPRESENTED BY TWO BYTES INSTEAD OF INTs FOUR, LONG BY 8, BUT 'L' IS NECESSARY FOR LONGER INTS
  val aFloat: Float = 4.434f
  // AN 'f' IS NECESSARY TO SIGNIFY A NUMBER IS A FLOAT
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effect
  aVariable += 1

  // VARIABLES ARE MUTABLE
}
