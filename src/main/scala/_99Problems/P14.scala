package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P14 {

  def duplicate[T](list: List[T]): List[T] = list match {
    case x :: xs => x +: x +: duplicate(xs)
    case Nil => Nil
  }

}
