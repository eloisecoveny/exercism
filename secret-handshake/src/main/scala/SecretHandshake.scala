object SecretHandshake {

  val key = Map(
    1000 -> "jump",
    100 -> "close your eyes",
    10 -> "double blink",
    1 -> "wink"
  )

  val range: List[Int] = List(128, 64, 32, 16, 8, 4, 2, 1)

    def commands(int: Int): List[String] = {
      val binary: Int = convertToBinary(int)
      // iterate over the key map and if

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