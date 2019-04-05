package exercises.part1basics

object Functions extends App {
  def greeting(name: String, age: Int): Unit = println("Hi, my name is " + name + " and I am " + age + " years old.")

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  greeting("Michiel", 30)
  println(factorial(5))
  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def recursive(test: Int): Boolean = {
      if (test == 1) true
      else (n % test != 0) && recursive(test - 1)
    }
    if (n <= 1) false
    else recursive(n / 2)
  }

  println(isPrime(19))
  println(isPrime(18))
  println(isPrime(2003))
}
