package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P10 {

  def encode[T](list: List[T]): List[(Int, T)] = {
    P09.pack(list).map(l => (l.size, l.head))
  }

}
