object Etl {
  def transform(legacyMap: Map[Int,Seq[String]]): Map[String,Int] = {
    val newMap = legacyMap.flatMap(res => {
      val score = res._1
      val letters = res._2
      letters.flatMap(letter => Map(letter.toLowerCase() -> score))
    })
    newMap
  }
}