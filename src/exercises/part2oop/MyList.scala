package exercises.part2oop

import java.security.KeyStore.TrustedCertificateEntry

import scala.annotation.tailrec

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  // polymorphic call
  protected def printElements: String
  override def toString: String = "[" + printElements + "]"

  def add[B >: A](element: B): MyList[B]

  def switch: MyList[A]

  // Higher order functions receive functions as parameters, or return functions as a result
  def map[B](transformer: A => B): MyList[B]
  def filter(filter: A => Boolean): MyList[A]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def foreach(f: A => Unit): Unit
  def sort(f: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C]
  def fold[B](start: B)(f: (B, A) => B): B

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def printElements: String = ""

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def switch: Nothing = throw new NoSuchElementException

  def filter(filter: Nothing => Boolean): MyList[Nothing] = Empty
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  def zipWith[B, C](list: MyList[B], f: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length.")
    else Empty
  def fold[B >: Nothing](start: B)(f: (B, Nothing) => B): B = start

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false

  def printElements: String = {
    @tailrec
    def tailRec(e: MyList[A], accumulator: String): String = {
      if (e.isEmpty) accumulator
      else tailRec(e.tail, s"$accumulator, ${e.head.toString()}")
    }
    tailRec(this.tail, s"${this.head}")
  }

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def switch: MyList[A] = {
    new Cons(t.head, new Cons(h, t.tail))
  }

  def filter(filter: A => Boolean): MyList[A] = {
    if (filter(h)) new Cons(h, t.filter(filter))
    else t.filter(filter)
  }

  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(f: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (f(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    val sortedTail = t.sort(f)
    insert(h, sortedTail)
  }

def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length.")
    else new Cons(f(h, list.head), t.zipWith(list.tail, f))
  }

  def fold[B](start: B)(f: (B, A) => B): B = t.fold(f(start, h))(f)

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}






object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
  println(listOfIntegers == cloneListOfIntegers)
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfStrings.map( { (s: String) =>
    @tailrec
    def addLoop(s: String, index: Int, accumulator: Int): Int = {
      if (s.length <= index) accumulator
      else addLoop(s, index + 1, accumulator + s(index).toInt)
    }
    addLoop(s, 0, 0)
  }))

 println(listOfIntegers.filter(_ % 2 == 0))

  val stringToChar = { (s: String) =>
    @tailrec
    def addLoop(s: String, index: Int, accumulator: MyList[Char]): MyList[Char] = {
      if (s.length <= index) accumulator
      else addLoop(s, index + 1, accumulator.add(s(index)))
    }
    val accumulator: MyList[Char] = Empty
    addLoop(s, 0, accumulator)
  }

  val flatMapTest = listOfStrings.flatMap(stringToChar)
  println(flatMapTest.toString)

  println(listOfIntegers.sort((x, y) => y - x).toString)
  println(listOfIntegers.tail.toString)
  println(listOfIntegers.fold[Int](0)(_ + _))

  val forCombinations = for {
    n <- listOfIntegers
    s <- listOfStrings
  } yield n.toString + "-" + s
  println(forCombinations)
}