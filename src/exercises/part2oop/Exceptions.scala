package exercises.part2oop

object Exceptions extends App {

  def stackOverflowRecursion(n: Int): Int = {
    if (n == 1) n
    else n * stackOverflowRecursion(n - 1)
  }

//  println(stackOverflowRecursion(120000))

  //val list = Array.ofDim(Int.MaxValue)

  println(-100 - Int.MinValue)
  println(PocketCalculator.subtract(-100, Int.MinValue))
}

class OverflowException extends RuntimeException
class UnderflowException extends RuntimeException
class MathCalculationException extends RuntimeException("Division by 0")

object PocketCalculator {

  def add(x: Int, y: Int): Int = {
    val result = x + y
    if (x > 0 && y > 0 && result < 0) throw new OverflowException
    else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
    else result
  }

  def subtract(x: Int, y: Int): Int = {
    if (y == Int.MinValue) add(add(x, 1), -add(y, 1))
    else add(x, -y)
  }

  def multiply(x: Int, y: Int): Int = {
    val result = x * y
    if (x < 0 && y < 0 && result < 0) throw new OverflowException
    else if (x > 0 && y > 0 && result < 0) throw new OverflowException
    else if (((x < 0 && y > 0) || (x > 0 && y < 0)) && result > 0) throw new UnderflowException
    else result
  }

  def divide(x: Int, y: Int): Float = {
    if (y != 0) x / y
    else throw new MathCalculationException
  }
}