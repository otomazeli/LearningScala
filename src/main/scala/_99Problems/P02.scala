package _99Problems

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P02 extends App {

  // Find the last but one element of a list.
  val list = List(1, 1, 2, 3, 5, 8)
  println("Input: " + list)

  // Alternatives
  println("Output Direct: " + list.takeRight(2).head)
  println("Output Direct 2: " + list.init.last)

  // Extending the previous function
  def penultimate[T](list: List[T]): T = list match {
    case x :: (_ :: Nil) => x
    case _ :: xs => penultimate(xs)
    case _ => throw new NoSuchElementException("list is empty")
  }

  println("Output Pattern Match: " + penultimate(list))
}
