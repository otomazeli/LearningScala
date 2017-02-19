package _99Problems

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P04 extends App {

  // Find the number of elements of a list.
  val list = List(1, 1, 2, 3, 5, 8)
  print("Input: " + list)

  def lengthRecursive[T](list: Traversable[T]): Int = {
    // Inner recursive function
    def counter(list: Traversable[T], length: Int): Int = list match {
      case _ :: xs => counter(xs, length + 1)
      case Nil => length
    }
    counter(list, 0)
  }

  print("Output Direct : " + list.length)
  println("Output Functional : " + lengthRecursive(list))
}
