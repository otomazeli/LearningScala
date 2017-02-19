package _99Problems

object P01 extends App {

  // Find the last element of a list.
  val list = List(1, 1, 2, 3, 5, 8)

  // Built in function
  println("Input: "+ list)

  // Functional function to find las element
  def lastRecursion[T](list: List[T]): T = list match {
    case x :: Nil => x
    case _ :: xs => lastRecursion(xs)
    case _ => throw new NoSuchElementException("list is empty")
  }

  println("Output Direct Solution: ", list.last)
  println("Output Recursive Function: " + lastRecursion(list))
  println("Check: ", lastRecursion(list) == 8)
}
