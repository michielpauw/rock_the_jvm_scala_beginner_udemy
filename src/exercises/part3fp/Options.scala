package exercises.part3fp

import scala.util.Random

object Options extends App {

  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")

  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)
    return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  /*
    if (c != null)
      return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect)
  /*
    if (connectionStatus == null)
      println(None)
    else
      print(Some(connectionStatus.get))
   */
  println(connectionStatus)
  /*
    if (status != null)
      println(status)
   */
  connectionStatus.foreach(println)

  config.get("host")
    .flatMap(host => config.get("port")
    .flatMap(port => Connection(host, port)))
      .map(connection => connection.connect)
    .foreach(println)

  val connectionStatus2 = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  println(connectionStatus2)
  connectionStatus2.foreach(println)
}