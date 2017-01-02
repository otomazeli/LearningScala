package _99Problems

import scala.annotation.tailrec

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P05 extends App {

  // Reverse a list.
  val list = List(1, 1, 2, 3, 5, 8)

  println(list.reverse)

  def reverseRecursive[T](list: List[T]): List[T] = {
    @tailrec
    def tail(src: List[T], dest: List[T]): List[T] = src match {
      case Nil => dest
      case x :: xs => tail(xs, x +: dest)
    }
    tail(list, List())
  }

  def sameAs[A](c: Traversable[A], d: Traversable[A]): Boolean =
    if (c.isEmpty) d.isEmpty
    else {
      val (e, f) = d span (c.head !=)
      if (f.isEmpty) false else sameAs(c.tail, e ++ f.tail)
    }

  println(reverseRecursive(list))
  println(sameAs(reverseRecursive(list), list.reverse))
}
