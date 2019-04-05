package exercises.part3fp

import scala.util.{Failure, Random, Try}

object HandlingFailure extends App {

  val host = "localhost"
  val port = "8080"
  val url = "www.test.com"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port.")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  //val connection = Try(HttpService.getConnection(hostname, port))
  //val html = connection.flatMap(c => Try(c.get(url)))
  //html.map(h => renderHTML(h))

  def LogTry[A](computation: => A): Try[A] = {
    Try(computation) recoverWith {
      case e: Throwable =>
        println(e)
        new Failure(e)
    }
  }

  for {
    connection <- LogTry(HttpService.getConnection(host, port))
    page <- LogTry(connection.get(url))
  } renderHTML(page)

  println("Different approach")

  for {
    possibleConnection <- HttpService.getSafeConnection(host, port)
    possiblePage <- possibleConnection.getSafe(url)
  } renderHTML(possiblePage)
  /*
    try {
      connection = HttpService.getConnection(host, port)
      try {
        page = connection.get(url)
        renderHTML(page)
      } catch (some other exception) {

      }
    } catch (exception) {

    }
   */
}
