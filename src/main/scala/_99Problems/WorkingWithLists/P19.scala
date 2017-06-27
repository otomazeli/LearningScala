package _99Problems.WorkingWithLists

/**
  * Rotate a list N places to the left.
  */
object P19 {

  private def makeNPositive[T](list: List[T], n: Int): Int =
    if (n < 0) list.length + n else n

  def rotate[T](n: Int, list: List[T]): List[T] = {
    val (first, second) = P17.splitN(makeNPositive(list, n), list)
    second ++: first
  }

}
