package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P15 {

  def duplicateN[T](times: Int, list: List[T]): List[T] = list match {
    case x :: xs => List.fill(times)(x) ++ duplicateN(times, xs)
    case Nil => Nil
  }

}
