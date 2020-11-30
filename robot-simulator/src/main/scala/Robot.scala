import Bearing.{Bearing, East, North, South, West}

case class Robot(bearing: Bearing, coordinates: (Int,Int)) {

  def turnRight: Robot = {
    this.copy(Bearing.turnRight(bearing), this.coordinates)
  }

  def turnLeft: Robot = {
    this.copy(Bearing.turnLeft(bearing), this.coordinates)
  }

  def advance: Robot = {
    val newCoordinates = bearing match {
      case North => this.coordinates.copy(coordinates._1, coordinates._2 + 1)
      case East => this.coordinates.copy(coordinates._1 + 1, coordinates._2)
      case South => this.coordinates.copy(coordinates._1, coordinates._2 - 1)
      case West => this.coordinates.copy(coordinates._1 - 1, coordinates._2)
    }
    this.copy(bearing, newCoordinates)
  }

  def simulate(input: String): Robot = {
    val instructions = input.split("")
    var robot: Robot = this.copy()
    instructions.foreach {
      case ("R") => robot = robot.turnRight
      case ("L") => robot = robot.turnLeft
      case ("A") => robot = robot.advance
    }
    robot
  }
}

object Bearing extends Enumeration {
  type Bearing = Value
  val North, East, South, West = Value

  def turnRight(bearing: Bearing): Bearing = {
    if (bearing.id < 3) Bearing(bearing.id + 1) else Bearing(0)
  }

  def turnLeft(bearing: Bearing): Bearing = {
    if (bearing.id > 0) Bearing(bearing.id - 1) else Bearing(3)
  }
}
