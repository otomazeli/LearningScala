package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P17 {

  def splitN[T](n: Int, list: List[T]): (List[T], List[T]) = {
    list.splitAt(n)
  }

}
