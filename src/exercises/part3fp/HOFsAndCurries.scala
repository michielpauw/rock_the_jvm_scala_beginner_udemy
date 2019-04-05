package exercises.part3fp

object HOFsAndCurries extends App {

  def toCurry(f: (Int, Int) => Int): (Int => (Int => Int)) = x => y => f(x, y)

  def fromCurry(f: (Int => (Int => Int))): (Int, Int) => Int = (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B = x => f(g(x))
  def andThen[A, B, C](f: A => B, g: B => C): A => C = x => g(f(x))
}
