package exercises.part3fp

class SocialNetwork(val people: Map[String, List[String]]) {

  def this() = this(Map[String, List[String]]())

  def add(person: String): SocialNetwork = new SocialNetwork(people + (person -> List[String]()))

  def add(person: String, friends: List[String]): SocialNetwork = new SocialNetwork(people + (person -> friends))

  def removeSimple(person: String): SocialNetwork = new SocialNetwork(people.filterKeys(x => x != person))

  def socialConnection(person1: String, person2: String): Boolean = {
    val allConnections = this.people(person1).flatMap(p => p +: this.people(p))
    allConnections.contains(person2)
  }

  def remove(person: String): SocialNetwork = {
    def unfriendAll(e: List[String], accumulator: SocialNetwork): SocialNetwork = {
      if (e.isEmpty) accumulator
      else unfriendAll(e.tail, accumulator.unfriend(person, e.head))
    }
    unfriendAll(this.people(person), this).removeSimple(person)
  }

  def friend(person1: String, person2: String): SocialNetwork = {
    def repeat(p1: String, p2: String, second: Boolean, accumulator: SocialNetwork): SocialNetwork = {
      val friends = accumulator.people(p1)
      val newSN: SocialNetwork = if (friends.contains(p2)) this else {
        val newFriends = accumulator.people(p1) :+ p2
        accumulator.removeSimple(p1).add(p1, newFriends)
      }
      if (second) newSN
      else repeat(p2, p1, true, newSN)
    }
    repeat(person1, person2, false, this)
  }

  def unfriend(person1: String, person2: String): SocialNetwork = {
    def repeat(p1: String, p2: String, second: Boolean, accumulator: SocialNetwork): SocialNetwork = {
      val newSN = {
        val newFriends = accumulator.people(p1).filter(name => name != p2)
        accumulator.removeSimple(p1).add(p1, newFriends)
      }
      if (second) newSN
      else repeat(p2, p1, true, newSN)
    }
    repeat(person1, person2, false, this)
  }

  def amountOfFriends(person: String): Int = this.people(person).length

  def allAmountsOfFriends(): Map[String, Int] = this.people.map(pair => pair._1 -> amountOfFriends(pair._1))

  def mostFriends(): String = allAmountsOfFriends().maxBy(_._2)._1

  def noFriends(): List[String] = allAmountsOfFriends().filter(pair => pair._2 == 0).map(_._1).toList
}

object TestSocialNetwork extends App {
  val sn = new SocialNetwork().add("Michiel").add("Lotte").add("Maarten").add("Wouter").add("Bea").add("Samuel")
  val sn2 = sn.friend("Michiel", "Lotte").friend("Michiel", "Bea").friend("Michiel", "Maarten").friend("Bea", "Lotte")
  val sn3 = sn2.unfriend("Michiel", "Bea")
  println(sn2.remove("Michiel").people.toString())
  println(sn2.people.toString())
  println(sn3.people.toString())
  println(sn2.amountOfFriends("Michiel"))
  println(sn2.mostFriends())
  println(sn2.allAmountsOfFriends())
  println(sn2.noFriends())
  println(sn2.socialConnection("Maarten", "Michiel"))
}