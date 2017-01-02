package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P20 extends App {

  // Remove the Kth element from a list.
  // Return the list and the removed element in a Tuple.
  // Elements are numbered from 0
  val inputList = List('a, 'b, 'c, 'd)
  val expectedResult = (List('a, 'c, 'd), 'b)

  println("Input: " + inputList)

  def removeAt[T](k: Int, list: List[T]): (List[T], T) =
    (list.take(k) ++ list.drop(k + 1), list(k))

  println("Output: " + removeAt(1, inputList))
  println("Check: " + (removeAt(1, inputList) == expectedResult))

}
