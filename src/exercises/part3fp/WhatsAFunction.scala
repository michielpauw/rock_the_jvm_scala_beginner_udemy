package exercises.part3fp

object WhatsAFunction extends App {

  val concatStrings = new Function2[String, String, String] {
    override def apply(s1: String, s2: String): String = s1 + s2
  }


  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(n: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(v: Int): Int = n + v
    }
  }

  val superAdder2 = (x: Int) => (v: Int) => x + v


  // Type will be: (Int) => Function1[Int, Int]
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder2(3)(4)) // curried function
}
