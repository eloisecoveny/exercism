object FlattenArray {

  def flatten(list: List[Any]): List[Any] = {
    val flattenedList = list
    flattenedList match {
      case x :: xs =>
        x match {
          case y :: ys => (y :: flatten(ys)) ::: flatten(xs)
          case _ => x :: flatten(xs)
        }
      case x => x
    }
  }
}