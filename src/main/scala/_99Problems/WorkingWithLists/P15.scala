package _99Problems.WorkingWithLists

/**
  * Duplicate the elements of a list a given number of times.
  */
object P15 {

  def duplicateN[T](times: Int, list: List[T]): List[T] = list match {
    case x :: xs => List.fill(times)(x) ++ duplicateN(times, xs)
    case Nil     => Nil
  }

}
