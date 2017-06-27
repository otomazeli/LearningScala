package _99Problems.WorkingWithLists

/**
  * Split a list into two parts.
  */
object P17 {

  def splitN[T](n: Int, list: List[T]): (List[T], List[T]) = {
    list.splitAt(n)
  }

}
