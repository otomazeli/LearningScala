package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P14 extends App {

  // Duplicate the elements of a list.
  val inputList = List('a, 'b, 'c, 'c, 'd)
  val expectedResult: List[Symbol] =
    List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

  println("Input: " + inputList)

  def duplicate[T](list: List[T]): List[T] = list match {
    case x :: xs => x +: x +: duplicate(xs)
    case Nil => Nil
  }

  println("Output: " + duplicate(inputList))
  println("Check: " + (duplicate(inputList) == expectedResult))

}
