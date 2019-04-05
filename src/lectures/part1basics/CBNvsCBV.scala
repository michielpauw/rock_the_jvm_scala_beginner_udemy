package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  // => implies that a function is called by name. So the actual function gets passed as a parameter and not its value.

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  //printFirst(infinite(), 34) // CRASHES!!
  printFirst(34, infinite()) // DOESN'T CRASH!

  // The by name parameter delays the evaluation of the expression passed until it's used.
}
