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
      val numberOfDigits: Int = binaryList.length
      if (binary < 10000) {
        createSecretHandshake(numberOfDigits - 1, binaryList)
      } else {
        createSecretHandshake(numberOfDigits - 1, binaryList).reverse.tail
      }
    }

  def createSecretHandshake(index: Int,
                            binaryList: List[String],
                            secretHandshake: List[String] = List.empty[String]): List[String] = {
    if (index > 0) {
      if (binaryList(index).toInt == 1) {
        createSecretHandshake(index - 1, binaryList, codes(index) +: secretHandshake)
      } else {
        createSecretHandshake(index - 1, binaryList, secretHandshake)
      }
    } else {
      if (binaryList(index).toInt == 1) {
        codes(index) +: secretHandshake
      } else {
        secretHandshake
      }
    }
  }

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