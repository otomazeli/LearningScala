package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P16 {

  def dropN[T](n: Int, list: List[T]): List[T] = {
    def drop(list: List[T], n: Int, index: Int): List[T] = {
      list match {
        case x :: xs if index % n != 0 => x +: drop(xs, n, index + 1)
        case _ :: xs if index % n == 0 => drop(xs, n, index + 1)
        case _ => Nil
      }
    }

    if (n == 0) list else drop(list, n, 1)
  }

}