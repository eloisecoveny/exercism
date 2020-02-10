class School {
  type DB = Map[Int, Seq[String]]

  val school = new School()
  val DB = school[DB]

  def add(name: String, g: Int) = {
    DB(g -> Seq(name))
  }

  def db: DB = ???

  def grade(g: Int): Seq[String] = ???

  def sorted: DB = ???
}
