package lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)
  val aTuple2 = Tuple2(2, "Hello, Scala")
  val aTuple3 = (2, "Hello, Scala")

  // Can group at most 22 elements of different types => they're used in conjunction with function types

  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), ("Daniel", 789), ("JIM", 999))
  val phonebook2 = Map(("Jim" -> 555), ("Daniel" -> 789)).withDefaultValue(-1)

  // a -> b: syntactic sugar for (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  // println(phonebook("Mary")) // -> Will throw a NoSuchElementException
  println(phonebook2("Mary")) // -> phonebook2 has a default value

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  println(phonebook.filter(_._2 > 600))
  // mapValues
  println(phonebook.mapValues(number => number * 10))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}
