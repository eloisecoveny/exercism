object FlattenArray {

  def flatten(array: List[Any]): List[Any] = {
    array.map(element => {
      element match {
        case int: Int => int
        case list: List[Any] => flatten(list)
      }
    })
  }
}