import Bearing.{Bearing, East, North, South, West}

case class Robot(b: Bearing, c: (Int,Int)) {
  var bearing: Bearing = Bearing(b.getValue)
  var coordinates: (Int, Int) = c

  def turnRight = bearing.turnRight
}

object Bearing extends Enumeration {
  type Bearing = String
  val North = "N"
  val East = "E"
  val South = "S"
  val West = "W"
}

case class Bearing(bearing: Bearing.Value) {
  val bearings = List(North, East, South, West)

  def getValue = bearing.outerEnum
  def turnRight = bearings.map(bearing -> bearing == )
}
