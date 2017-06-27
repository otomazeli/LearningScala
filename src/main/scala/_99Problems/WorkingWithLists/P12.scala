package _99Problems.WorkingWithLists

import scala.annotation.tailrec

/**
  * Decode a run-length encoded list.
  */
object P12 {

  def decode[T](encoded: List[Any]): List[T] = {
    @tailrec
    def decodeR(encoded: List[Any], result: List[T]): List[T] = encoded match {
      case ((n: Int, e: T) :: xs) => decodeR(xs, result ++ List.fill(n)(e))
      case ((e: T) :: xs)         => decodeR(xs, result :+ e)
      case Nil                    => result
    }
    decodeR(encoded, Nil)
  }

}
