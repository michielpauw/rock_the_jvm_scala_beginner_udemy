package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  // EXPRESSIONS ARE EVALUATED TO A VALUE

  println(2 + 3 * 4)

  // + - * / % & (bitwise AND) | (bitwise OR) ^ (bitwise XOR) << (bitwise left shift) >> (bitwise right shift)
  // >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /=
  aVariable %= 4
  // OF COURSE THIS ONLY WORKS WITH VARIABLES ..... side effects!
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(!aCondition) 5 else 3 // IF EXPRESSION, NOT AN INSTRUCTION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  // AVOID WHILE LOOPS IN FUNCTIONAL PROGRAMMING!
  var i = 0
  val aWhile = while (i < 10)
    {
      println(i)
      i += 1
    }
  // NEVER WRITE THIS AGAIN!!

  // EVERYTHING IN SCALA IS AN EXPRESSION!!

  val aWeirdValue = (aVariable = 3) // Unit === void, side effects are expressions returning Units
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning of vars --> all return Units

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // A code block is an expression (like everything else in Scala)
  // The value of a code block is the value of its last expression.

  // val anotherValue = z + 1 // won't work because z is defined in the code block.
  println(aCodeBlock)

  // ANSWERS TO QUESTIONS:
  // 1. "hello world" is of type String, println() is of type Unit
  // 2. true, 42
}
