package _99Problems.WorkingWithLists

/**
  * Pack consecutive duplicates of list elements into sublists.
  */
object P09 {

  def pack[T](list: List[T]): List[List[T]] = list match {
    case x :: xs =>
      (x +: xs.takeWhile(el => el == x)) +: pack(xs.dropWhile(el => el == x))
    case Nil => Nil
  }

}
