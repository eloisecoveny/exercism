object HighScores {
  implicit val ordering: Ordering[Int] = Ordering.Int

  def latest(scores: List[Int]): Int = scores.last

  def personalBest(scores: List[Int]): Int = sortScores(scores).head

  def personalTop(scores: List[Int]): List[Int] = sortScores(scores).take(3)

  def report(scores: List[Int]): String = {
    val latestScore = scores.reverse.head
    val highestScore = sortScores(scores).head
    if (latestScore.equals(highestScore)) s"Your latest score was $latestScore. That's your personal best!"
    else s"Your latest score was $latestScore. That's ${highestScore - latestScore} short of your personal best!"
  }

  def sortScores(scores: List[Int]) = scores.sorted.reverse
}