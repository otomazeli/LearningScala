package _99Problems

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P03 extends App {

  // Find the Kth element of a list.
  val list = List(1, 1, 2, 3, 5, 8)

  println(list(5))

  // Function equivalent
  def kthRecursive[T](list: List[T], k: Int): T = list match {
    case x :: xs if k == 0 => x
    case x :: xs => kthRecursive(xs, k - 1)
    case _ => throw new NoSuchElementException
  }

  println(kthRecursive(list, 5))
}
