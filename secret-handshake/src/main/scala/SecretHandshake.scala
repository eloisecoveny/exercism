import SecretHandshake.{codes, createSecretHandshake}

import scala.annotation.tailrec

object SecretHandshake {

  val codeMapping = Map(
    1 -> "wink",
    10 -> "double blink",
    100 -> "close your eyes",
    1000 -> "jump",
    10000 -> ""
  )

  val codes = List("wink", "double blink", "close your eyes", "jump", "")

  val range: List[Int] = List(128, 64, 32, 16, 8, 4, 2, 1)

  def commands(int: Int): List[String] = {
    val binary: Int = convertToBinary(int)
    val binaryList: List[String] = binary.toString.split("").toList.reverse
    if (binary < 10000) {
      createSecretHandshake(binaryList.length - 1, binaryList)
    } else {
      createSecretHandshake(binaryList.length - 1, binaryList).reverse.tail
    }
  }

  def createSecretHandshake(index: Int,
                            binaryList: List[String],
                            gestures: List[String] = List.empty[String]): List[String] = {

    binaryList(index) match {
      case "1" if index > 0 => createSecretHandshake(index - 1, binaryList, codes(index) +: gestures)
      case "1" => codes(index) +: gestures
      case "0" if index > 0 => createSecretHandshake(index - 1, binaryList, gestures)
      case "0" => gestures
    }
  }

  @tailrec
  def convertToBinary(int: Int, binary: List[String] = List.empty[String], index: Int = 0): Int = {
    if (index < range.length) {
      if (int >= range(index)) {
        convertToBinary(int - range(index), binary :+ "1", index + 1)
      } else {
        convertToBinary(int, binary :+ "0", index + 1)
      }
    } else {
      binary.mkString.toInt
    }
  }
}