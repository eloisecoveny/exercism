import scala.annotation.tailrec

class Accumulate {
  def accumulate[A, B](f: (A) => B, list: List[A]): List[B] = {

    @tailrec
    def accumulation(input: List[A], output: List[B]): List[B] = {
      if (input.isEmpty) output
      else accumulation(input.tail, output :+ f(input.head))
    }

    accumulation(list, List.empty)
  }
}
