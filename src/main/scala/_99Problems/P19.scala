package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P19 {

  private def makeNPositive[T](list: List[T], n: Int): Int =
    if (n < 0) list.length + n else n

  def rotate[T](n: Int, list: List[T]): List[T] = {
    val (first, second) = P17.splitN(makeNPositive(list, n), list)
    second ++: first
  }

}
