package _99Problems

import scala.annotation.tailrec

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P05 {

  def reverseRecursive[T](list: List[T]): List[T] = {
    @tailrec
    def tail(src: List[T], dest: List[T]): List[T] = src match {
      case Nil => dest
      case x :: xs => tail(xs, x +: dest)
    }
    tail(list, List())
  }

}
