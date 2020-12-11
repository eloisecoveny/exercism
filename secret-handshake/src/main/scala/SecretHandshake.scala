import scala.annotation.tailrec

object SecretHandshake {

  val codeMapping = Map(
    1 -> "wink",
    10 -> "double blink",
    100 -> "close your eyes",
    1000 -> "jump",
    10000 -> ""
  )

  val gestures = List("wink", "double blink", "close your eyes", "jump", "")

  def commands(int: Int): List[String] = {
    val binaryString: String = int.toBinaryString
    val binaryList: List[String] = binaryString.split("").toList.reverse
    if (binaryString.toInt < 10000) {
      createSecretHandshake(binaryList.length - 1, binaryList)
    } else {
      createSecretHandshake(binaryList.length - 1, binaryList).reverse.tail
    }
  }

  @tailrec
  def createSecretHandshake(index: Int,
                            binaryList: List[String],
                            handshake: List[String] = List.empty[String]): List[String] = {

    binaryList(index) match {
      case "1" if index > 0 => createSecretHandshake(index - 1, binaryList, gestures(index) +: handshake)
      case "1" => gestures(index) +: handshake
      case "0" if index > 0 => createSecretHandshake(index - 1, binaryList, handshake)
      case "0" => handshake
    }
  }
}