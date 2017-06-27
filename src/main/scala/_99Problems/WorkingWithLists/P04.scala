package _99Problems.WorkingWithLists

/**
  * Find the number of elements of a list.
  */
object P04 {

  def lengthRecursive[T](list: Traversable[T]): Int = {
    @scala.annotation.tailrec
    def counter(list: Traversable[T], length: Int): Int = list match {
      case _ :: xs => counter(xs, length + 1)
      case Nil     => length
    }
    counter(list, 0)
  }

}
