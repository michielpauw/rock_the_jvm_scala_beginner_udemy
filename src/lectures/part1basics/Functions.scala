package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  // A function implementation is one single expression. But a block can be used!

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) // works if no parameters required

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  println(aRepeatedFunction("Hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION!

  // The return type of a function can also be inferred by the compiler (so it's not mandatory).
  // BUT! It is mandatory for a recursive function! So as best practice always specify the return type.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // A function can return a Unit

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }
}
