package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P17 extends App {

  // Split a list into two parts.
  // Drop every Nth element from a list.
  val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val expectedResult =
    (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  println("Input: " + inputList)

  def splitN[T](n: Int, list: List[T]): (List[T], List[T]) = {
    list.splitAt(n)
  }

  println("Output: " + splitN(3, inputList))
  println("Check: " + (splitN(3, inputList) == expectedResult))

}
