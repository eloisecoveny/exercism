case class SecretHandshake {

  val key = Map(
    1000 -> "jump",
    100 -> "close your eyes",
    10 -> "double blink",
    1 -> "wink"
  )

  val range = List(128, 64, 32, 16, 8, 4, 3, 1)

  def commands(int: Int): List[String] = {
    val binary = convertToBinary(int)
    if (int > 0) {
      // iterate over the map and
    }
  }

  def convertToBinary(int: Int, binary: List[Int] = List()): Int = {
    range.map(number => {
      if (int == 0) {
        binary.reduce(_)
      } else if (int > number) {
        convertToBinary(int - number, binary :+ 1)
      } else {
        convertToBinary(int, binary :+ 0)
      }
    })
  }
}