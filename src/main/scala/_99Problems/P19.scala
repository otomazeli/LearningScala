package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P19 extends App {

  // Rotate a list N places to the left.
  val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val expectedResult = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

  println("Input: " + inputList)

  private def makeNPositive[T](list: List[T], n: Int): Int =
    if (n < 0) list.length + n else n

  def rotate[T](n: Int, list: List[T]): List[T] = {
    val (first, second) = P17.splitN(makeNPositive(list, n), list)
    second ++: first
  }

  println("Output: " + rotate(3, inputList))
  println("Check: " + (rotate(3, inputList) == expectedResult))

}
