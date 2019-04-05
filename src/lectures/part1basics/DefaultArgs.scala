package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  // We can pass a default argument value.
  def trFact(x: Int, accumulator: BigInt = 1): BigInt = {
    if (x <= 1) accumulator
    else trFact(x - 1, x * accumulator) // TAIL RECURSION
  }

  val fact10 = trFact(10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("Saving picture.")
  // savePicture(800, 600) --> Unclear for compiler

  /*
    Solutions:
    1. pass in every leading argument
    2. name the arguments
   */
  savePicture(width = 800, height = 800)

  savePicture(height = 600, width = 800, format = "bmp")

}
