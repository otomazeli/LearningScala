package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P13 {

  def encodeDirectSpan[T](list: List[T]): List[Any] = list match {
    case x :: xs =>
      val (consecutiveDuplicates, remaining) = xs.span(_ == x)
      (consecutiveDuplicates.length + 1, x) +: encodeDirectSpan(remaining)
    case Nil => Nil
  }

}
