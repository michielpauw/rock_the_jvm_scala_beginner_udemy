package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // ^^ This will crash with a Null pointer exception
  // throwing and catching exceptions

  // 1. throwing exceptions
  // val aValue: String = throw new NullPointerException
  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => println("Caught a Runtime exception.")
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("Finally")
  }

  // potentialFail has type AnyVal (in this case), because try returns something different than catch
  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  // throw exception
  // ^^ will now crash your programs
}
