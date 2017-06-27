package _99Problems.WorkingWithLists

/**
  * Duplicate the elements of a list.
  */
object P14 {

  def duplicate[T](list: List[T]): List[T] = list match {
    case x :: xs => x +: x +: duplicate(xs)
    case Nil     => Nil
  }

}
