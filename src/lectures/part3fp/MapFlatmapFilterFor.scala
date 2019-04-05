package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  println(list.filter(_ % 2 == 0))

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))


  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")

  // "iterating"
  val perms = numbers.flatMap( (n: Int) => chars.map( (c: Char) => n.toString + c))
  val perms2 = numbers.flatMap( (n: Int) => chars.flatMap( (c: Char) => colors.map( color => n.toString + c + "-" + color)))
  println(perms2)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield n.toString + c + "-" + color
  println(forCombinations)

  // for-comprehensions can include filters like this:
  val perms3 = numbers.filter(_ % 2 == 0).flatMap( (n: Int) => chars.flatMap( (c: Char) => colors.map( color => n.toString + c + "-" + color)))

  val forCombinations2 = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield n.toString + c + "-" + color

  val forCombinations3 = for {
    n <- numbers.filter(_ % 2 == 0)
    c <- chars
    color <- colors
  } yield n.toString + c + "-" + color
  println(perms3)
  println(forCombinations2)
  println(forCombinations3)

  // foreach (like map, but receives a function returning a Unit)
  list.foreach(println)
  // with for-comprehensions
  for {
    n <- list
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }
}
