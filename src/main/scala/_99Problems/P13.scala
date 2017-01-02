package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P13 extends App {

  // Run-length encoding of a list (direct solution).
  // Implement the so-called run-length encoding data compression method
  // directly. I.e. don't use other methods you've written (like P09's pack); do
  // all the work directly.

  val inputList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  val expectedResult: Seq[(Int, Symbol)] =
    List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

  println("Input: " + inputList)

  def encode_direct_span[T](list: List[T]): List[Any] = list match {
    case x :: xs =>
      val (consecutiveDuplicates, remaining) = xs.span(_ == x)
      (consecutiveDuplicates.length + 1, x) +: encode_direct_span(remaining)
    case Nil => Nil
  }

  println("Output: " + encode_direct_span(inputList))
  println("Check: " + (encode_direct_span(inputList) == expectedResult))

}
