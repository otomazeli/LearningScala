package _99Problems

import scala.annotation.tailrec

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P12 extends App {

  // Decode a run-length encoded list.
  // Given a run-length code list generated as specified in problem
  // P10, construct its uncompressed version.
  val inputList = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
  val expectedResult: Seq[Symbol] =
    List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  println("Input: " + inputList)

  def decode[T](encoded: List[Any]): List[T] = {
    @tailrec
    def decodeR(encoded: List[Any], result: List[T]): List[T] = encoded match {
      case ((n: Int, e: T) :: xs) => decodeR(xs, result ++ List.fill(n)(e))
      case ((e: T) :: xs) => decodeR(xs, result :+ e)
      case Nil => result
    }
    decodeR(encoded, List())
  }

  println("Output: " + decode(inputList))
  println("Check: " + (decode(inputList) == expectedResult))

}
