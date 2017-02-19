package _99Problems

import scala.annotation.tailrec

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P21 extends App {

  // Insert an element at a given position into a list.
  val inputList = List('a, 'b, 'c, 'd)
  val expectedResult = List('a, 'new, 'b, 'c, 'd)

  println("Input: " + inputList)

  def insertAt[T](t: T, pos: Int, list: List[T]): List[T] = {
    @tailrec
    def insertAt(remaining: List[T], first: List[T], cur: Int): List[T] =
      remaining match {
        case _ if cur == pos => (first :+ t) ++ remaining
        case x :: xs => insertAt(xs, first :+ x, cur + 1)
        case _ => Nil
      }
    insertAt(list, List(), 0)
  }

  println("Output: " + insertAt('new, 1, inputList))
  println("Check: " + (insertAt('new, 1, inputList) == expectedResult))

}
