object FlattenArray {

  def flatten(list: List[Any]): List[Any] = {
    println(s"this is the list: $list")
    list match {
      case x :: xs => {
        println(s"ok we've got a list now, head: $x tail: $xs")
        x match {
          case y :: ys if y.isInstanceOf[Int] && ys.nonEmpty => {
            println(s"this should be an int: $y")
            if (xs.nonEmpty) (y :: flatten(ys)) ::: flatten(xs)
            else y :: flatten(ys)
          }
          case y :: ys if y.isInstanceOf[Int] => {
            println(s"this should be an int: $y, with empty list $ys")
            if (xs.nonEmpty) {
              println(s"... and remaining list $xs")
              List(y) ::: flatten(xs)
            }
            else List(y)
          }
          case y :: ys if ys.nonEmpty => {
            println(s"this should be a list: $y")
            if (xs.nonEmpty) {
              println(s"flattening $y and concatening to $ys and then $xs")
              (flatten(y.asInstanceOf[List[Any]]) :: flatten(ys)) ::: flatten(xs)
            }
            else flatten(y.asInstanceOf[List[Any]]) :: flatten(ys)
          }
          case y :: ys => {
            println(s"this should be a list: $y and an empty list $ys")
            if (xs.nonEmpty) flatten(y.asInstanceOf[List[Any]]) ::: flatten(xs)
            else flatten(y.asInstanceOf[List[Any]])
          }
          case int: Int => {
            println(s"straight up, got an int: $int")
            if (xs.nonEmpty) {
              println(s"...now will concat it with $xs")
              int :: flatten(xs)
            }
            else {
              println(s"...and will now return ye olde $int")
              List(int)
            }
          }
        }
      }
    }
  }
}