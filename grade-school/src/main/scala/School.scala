import scala.collection.immutable.HashMap
import scala.collection.mutable

class School {
  type DB = Map[Int, Seq[String]]

  var database: DB = Map()

  def add(name: String, g: Int) = {
//    database.map(grade => if (grade._1 == g) {
//      grade + name
//    } else {
//      database ++ Map(g -> Seq(name))
//    })

    if (database.contains(g)) {
      database = database(g) + name
    } else {
      database = database ++ Map(g -> Seq(name))
    }
  }

  def db: DB = database

  def grade(g: Int): Seq[String] = ???

  def sorted: DB = ???
}
