package _99Problems

import scala.annotation.tailrec

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P05 extends App {

  // Reverse a list.
  val list = List(1, 1, 2, 3, 5, 8)
  println("Input List: " + list.reverse)

  def reverseRecursive[T](list: List[T]): List[T] = {
    @tailrec
    def tail(src: List[T], dest: List[T]): List[T] = src match {
      case Nil => dest
      case x :: xs => tail(xs, x +: dest)
    }
    tail(list, List())
  }

  println("Output: " + reverseRecursive(list))
  println("Check: " + reverseRecursive(list) == list.reverse)
}
