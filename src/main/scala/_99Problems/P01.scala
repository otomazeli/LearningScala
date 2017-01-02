package _99Problem

object P01 extends App {

  // Find the last element of a list.
  val list = List(1, 1, 2, 3, 5, 8)

  // Built in function
  println(list.last)

  def lastRecursion[T](list: List[T]): T = list match {
    case x :: Nil => x
    case _ :: xs => lastRecursion(xs)
    case _ => throw new NoSuchElementException("list is empty")
  }

  println(lastRecursion(list))
}
