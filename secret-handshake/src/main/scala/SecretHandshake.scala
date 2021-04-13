import scala.annotation.tailrec

object SecretHandshake {

  val defaultGestures = List("wink", "double blink", "close your eyes", "jump")

  def commands(int: Int, gestures: List[String] = defaultGestures): List[String] = {
    if (int < 16) createSecretHandshake(int, gestures)
    else createSecretHandshake(int, gestures).reverse
  }

  @tailrec
  def createSecretHandshake(value: Int,
                            gestures: List[String],
                            handshake: List[String] = List.empty[String]): List[String] = {
    gestures match {
      case Nil => handshake
      case head :: tail =>
        if ((value & 1) == 1) createSecretHandshake(value >> 1, tail, handshake :+ head)
        else createSecretHandshake(value >> 1, gestures.tail, handshake)
    }
  }
}