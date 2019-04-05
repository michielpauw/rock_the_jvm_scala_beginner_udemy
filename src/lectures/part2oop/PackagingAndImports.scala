package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}
// import playground._ // import entire package

import java.util.Date
// import java.sql.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // Package members are accessible by their simple name
  val Person = new Person("Michiel")

  // import the package
  // val princess = new Cinderella
  val princess = new Princess
  // or
  val otherPrincess = new playground.Cinderella // use the fully qualified name

  // Packages are in hierarchy
  // Matching folder structure.

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  val d = new Date // compiler will assume it's first import

  // 1. Use FQN
  val sDate = new java.sql.Date(2018, 5, 4)

  // 2. Use aliasing: {Date => SqlDate}
  val sDate2 = new SqlDate(2018, 5, 4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
