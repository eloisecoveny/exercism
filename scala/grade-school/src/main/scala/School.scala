class School {

  type DB = Map[Int,Seq[String]]

  var database: DB = Map()

  def add(student: String, grade: Int) = {
    if(database.contains(grade)) database += (grade -> (this.grade(grade) :+ student))
    else database += (grade -> Seq(student))
  }

  def db: DB = database

  def grade(gr: Int) = {
    database.getOrElse(gr,Seq())
  }

  def sorted = {
    database.toSeq.sortBy(_._1)
      .map(gr => gr._1 -> gr._2.sorted)
      .toMap
  }
}