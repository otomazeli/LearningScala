package _99Problems.WorkingWithLists

/**
  * Run-length encoding of a list.
  */
object P10 {

  def encode[T](list: List[T]): List[(Int, T)] = {
    P09.pack(list).map(l => (l.size, l.head))
  }

}
