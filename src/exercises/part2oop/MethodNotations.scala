package exercises.part2oop

object MethodNotations extends App {

  val mary = new Person("Mary", "Inception", 24)

  println(mary learns "Python")
  println(mary learnsScala)
  println(+mary.age)
  println((+mary).age)
  println((mary + "Her Awesomeness")())
  println((mary + "Her Awesomeness").learnsScala())
  println(mary(4))

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}."
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}."
    def +(nickname: String): Person = new Person(s"${this.name} ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck!?"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(learns: String): String = s"$name learns $learns"
    def learnsScala(): String = this learns "Scala"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."
    def apply(n: Int): String = s"$name watched her favorite movie $favoriteMovie $n times."
  }
}
