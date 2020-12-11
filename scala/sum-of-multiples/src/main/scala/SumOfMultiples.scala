object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = factors.flatMap(getMultiples(_, limit)).sum

  def getMultiples(int: Int, limit: Int): List[Int] = Range(0, limit, int).toList
}

