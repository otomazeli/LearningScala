package _99Problems.WorkingWithLists

object P01 {
  @scala.annotation.tailrec
  def lastRecursion[T](list: List[T]): T = list match {
    case x :: Nil => x
    case _ :: xs  => lastRecursion(xs)
    case _        => throw new NoSuchElementException("list is empty")
  }
}
