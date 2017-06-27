package _99Problems.WorkingWithLists

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P03 {
  @scala.annotation.tailrec
  def kthRecursive[T](list: Traversable[T], k: Int): T = list match {
    case x :: _ if k == 0 => x
    case _ :: xs          => kthRecursive(xs, k - 1)
    case _                => throw new NoSuchElementException
  }

}
