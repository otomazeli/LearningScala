package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P08 {

  def compress[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => h :: compress(tail.dropWhile(_ == h))
  }

}
