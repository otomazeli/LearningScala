package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P18 extends App {

  // Extract a slice from a list.
  // Given two indices, I and K, the slice is the list containing the elements
  // from and including the Ith element up to but not including the Kth element
  // of the original list. Start counting the elements with 0.
  val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val expectedResult = List('d, 'e, 'f, 'g)

  println("Input: " + inputList)

  def slice[T](start: Int, end: Int, list: List[T]): List[T] =
    list.slice(start, end)

  println("Output: " + slice(3, 7, inputList))
  println("Check: " + (slice(3, 7, inputList) == expectedResult))

}
