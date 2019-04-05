package exercises.part2oop

object OOBasics extends App {

  val counter = new Counter()
  counter.increment(10).print()
}

class Writer(val firstName: String, val lastName: String, val year: Int) {

  def fullName(): String = s"$firstName $lastName"
}

class Novel(val name: String, val yearOfRelease: Int, author: Writer) {

  def authorAge(): Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(yearOfRelease: Int): Novel = new Novel(name, yearOfRelease, author)
}

class Counter(val n: Int = 0) {

  def currentCount(): Int = n

  def increment(): Counter =  new Counter(n + 1) // immutability extended to objects
  def increment(amount: Int): Counter =  {
    if (amount <= 0) this
    else increment().increment(amount - 1)
  }

  def decrement(): Counter =  new Counter(n - 1)
  def decrement(amount: Int): Counter =  {
    if (amount <= 0) this
    else decrement().decrement(amount - 1)
  }

  def print(): Unit = println(n)
}