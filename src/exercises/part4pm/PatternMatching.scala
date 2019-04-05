package exercises.part4pm

object PatternMatching extends App {

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(in: Expr): String = {
    in match {
      case Number(n: Int) => n.toString
      case Sum(e1: Expr, e2: Expr) => s"${show(e1)} + ${show(e2)}"
      case Prod(e1: Sum, e2: Sum) => s"(${show(e1)}) * (${show(e2)})"
      case Prod(e1: Sum, e2: Expr) => s"(${show(e1)}) * ${show(e2)}"
      case Prod(e1: Expr, e2: Sum) => s"${show(e1)} * (${show(e2)})"
      case Prod(e1: Expr, e2: Expr) => s"${show(e1)} * ${show(e2)}"
      case _ => "No valid input"
    }
  }
  println(show(Sum(Sum(Number(2), Number(4)), Number(3))))
  println(show(Sum(Prod(Number(2), Number(4)), Number(3))))
  println(show(Prod(Prod(Number(2), Number(4)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(4)), Number(3))))
  println(show(Prod(Number(2), Sum(Number(4), Number(3)))))
  println(show(Prod(Sum(Number(2), Number(8)), Sum(Number(4), Number(3)))))
  println(show(Prod(Sum(Number(2), Number(8)), Prod(Number(4), Number(3)))))
}
