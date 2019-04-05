package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // Problem: oop

  // Scala had to find some clever tricks in order to make it a truly functional language

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // the advantage of the Scala apply method:
  println(doubler(2))

  // function types by default supported by Scala= Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  // type of adder "(Int, Int) => Int", which is syntactic sugar for Function2

  // Function types Function2[A, B, R] == (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS!!
}

trait Action[A, B] {
  def execute(element: A): B
}

trait MyFunction[A, B] {
  def apply(element: A): B
}