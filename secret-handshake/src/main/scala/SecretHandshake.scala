import scala.annotation.tailrec

object SecretHandshake {

  val gestures = List("wink", "double blink", "close your eyes", "jump")

  def commands(int: Int, gestures: List[String] = gestures): List[String] = {
    if (int < 16) createSecretHandshake(int, gestures)
    else createSecretHandshake(int, gestures).reverse
  }

  @tailrec
  def createSecretHandshake(value: Int,
                            gestures: List[String],
                            handshake: List[String] = List.empty[String]): List[String] = {
    if (gestures.isEmpty) handshake
    else {
      value.toBinaryString.last match {
        case '1' => createSecretHandshake (value >> 1, gestures.tail, handshake :+ gestures.head)
        case _ => createSecretHandshake (value >> 1, gestures.tail, handshake)
      }
    }
  }
}