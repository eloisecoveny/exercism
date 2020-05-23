object Hamming {

  def distance(x: String, z: String): Option[Int] = {
    if (x == z) Some(0)
    else if (x.length != z.length) None
    else calculate(x, z, 0, 0)
  }

  def calculate(x: String, z: String, it: Int, dist: Int): Option[Int] = {
    val index = it
    val distance = dist
    if (x(index) != z(index)) {
      if (x.length > index + 1) calculate(x, z, index + 1, distance + 1)
      else Some(distance + 1)
    } else if (x.length > index + 1) calculate(x, z, index + 1, distance)
    else Some(distance)
  }
}