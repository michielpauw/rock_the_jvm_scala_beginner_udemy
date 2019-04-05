package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

  // For big values of n, the call stack will cause a stack overflow... So we need a different approach.

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION
    }
    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 2 * 3 * ... * 10 * 1)
    = 1 * 2 * ... * 10
   */

  println(anotherFactorial(5000))

  /*
    Why doesn't this one crash with a stack overflow?
    in anotherFactorial, we write factHelper as the last expression of its code path. This allows Scala to preserve
    stack frames. In the original implementation, we needed one recursive stack frame for each separate call, so it
    can compute the intermediate result.
    In the new function, Scala doesn't need to save intermediate results.

    This is called TAIL RECURSION: use recursive call as the LAST expression.
    You can add @tailrec, so the compiler can check whether the function is tail recursive.
   */

  // WHEN YOU NEED LOOPS: USE TAIL RECURSION!
}
