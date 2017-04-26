package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P09 {

  def pack[T](list: List[T]): List[List[T]] = list match {
    case x :: xs =>
      (x +: xs.takeWhile(el => el == x)) +: pack(xs.dropWhile(el => el == x))
    case Nil => Nil
  }

}
