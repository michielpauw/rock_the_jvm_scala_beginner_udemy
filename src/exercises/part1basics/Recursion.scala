package exercises.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def concat(aString: String, n: Int): String = {
    @tailrec
    def concatHelper(x: Int, accumulator: String): String = {
      if (x <= 1) accumulator
      else concatHelper(x - 1, accumulator + aString)
    }
    concatHelper(n, aString)
  }

  println(concat("Bonjour ", 5))

  def factorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION
    }
    factHelper(n, 1)
  }

  def fibonacci(n: Int): BigInt = {
    @tailrec
    def fibHelper(x: Int, accumulator_1: BigInt, accumulator_2: BigInt): BigInt = {
      if (x <= 2) accumulator_1
      else fibHelper(x - 1, accumulator_1 + accumulator_2, accumulator_1)
    }
    if (n <= 2) 1
    fibHelper(n, 1, 1)
  }

  println(factorial(5))
  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def recursive(test: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (test == 1) true
      else  recursive(test - 1, (n % test != 0))
    }
    if (n <= 1) false
    else recursive(n / 2, true)
  }

  println(isPrime(19))
  println(isPrime(18))
  println(isPrime(2003))
}
