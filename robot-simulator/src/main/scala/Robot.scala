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
    Robot(this.bearing, newCoordinates)
  }

  def simulate(input: String): Robot = {
    val instructions = input.split("")
    var robot: Robot = this
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
    val index = bearing.id
    if (index < 3) {
      Bearing(index + 1)
    } else {
      Bearing.North
    }
  }
  def turnLeft(bearing: Bearing): Bearing = {
    val index = bearing.id
    if (index > 0) {
      Bearing(index - 1)
    } else {
      Bearing.West
    }
  }
}
