object Etl {
  def transform(legacyMap: Map[Int,Seq[String]]): Map[String,Int] = {
    val newMap = legacyMap.flatMap {
        case (score, letters) => letters
          .flatMap(letter => Map(letter.toLowerCase() -> score))
    }
    newMap
  }
}