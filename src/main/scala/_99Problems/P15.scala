package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P15 extends App {

  // Duplicate the elements of a list a given number of times.
  val inputList = List('a, 'b, 'c, 'c, 'd)
  val expectedResult: List[Symbol] =
    List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

  println("Input: " + inputList)

  def duplicateN[T](times: Int, list: List[T]): List[T] = list match {
    case x :: xs => List.fill(times)(x) ++ duplicateN(times, xs)
    case Nil => Nil
  }

  println("Output: " + duplicateN(3, inputList))
  println("Check: " + (duplicateN(3, inputList) == expectedResult))

}
