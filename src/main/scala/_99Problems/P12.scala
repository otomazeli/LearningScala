package _99Problems

import scala.annotation.tailrec

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P12 {

  def decode[T](encoded: List[Any]): List[T] = {
    @tailrec
    def decodeR(encoded: List[Any], result: List[T]): List[T] = encoded match {
      case ((n: Int, e: T) :: xs) => decodeR(xs, result ++ List.fill(n)(e))
      case ((e: T) :: xs) => decodeR(xs, result :+ e)
      case Nil => result
    }
    decodeR(encoded, List())
  }

}
