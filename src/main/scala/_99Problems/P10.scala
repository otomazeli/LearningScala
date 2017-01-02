package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P10 extends App {

  // Run-length encoding of a list.
  val inputList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  // Use the result of problem P09 to implement the so-called run-length encoding data compression method.
  // Consecutive duplicates of elements are encoded as tuples (N, E) where N is
  // the number of duplicates of the element E.
  val expectedResult: Seq[(Int, Symbol)] =
    List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

  println("Input: " + inputList)

  def encode[T](list: List[T]): List[(Int, T)] = {
    P09.pack(list).map(l => (l.size, l.head))
  }

  println("Output: " + encode(inputList))
  println("Check: " + (encode(inputList) == expectedResult))

}
