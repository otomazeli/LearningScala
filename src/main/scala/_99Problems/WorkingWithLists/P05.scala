package _99Problems.WorkingWithLists

/**
  * Reverse a list.
  */
object P05 {

  def reverseRecursive[T](list: List[T]): List[T] = {
    @scala.annotation.tailrec
    def tail(src: List[T], dest: List[T]): List[T] = src match {
      case Nil     => dest
      case x :: xs => tail(xs, x +: dest)
    }
    tail(list, Nil)
  }

}
