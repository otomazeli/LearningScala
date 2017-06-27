package _99Problems.WorkingWithLists

/**
  * Run-length encoding of a list (direct solution).
  */
object P13 {

  def encodeDirectSpan[T](list: List[T]): List[Any] = list match {
    case x :: xs =>
      val (consecutiveDuplicates, remaining) = xs.span(_ == x)
      (consecutiveDuplicates.length + 1, x) +: encodeDirectSpan(remaining)
    case Nil => Nil
  }

}
