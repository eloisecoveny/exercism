object Hamming {

  def distance(x: String, z: String): Option[Int] = {
    if (x == z) Some(0)
    else if (x.length != z.length) None
    else Some(x.zip(z).count(pair => pair._1 != pair._2))
  }
}