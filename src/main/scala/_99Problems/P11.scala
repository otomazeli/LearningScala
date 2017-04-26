package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P11 {

  def encode_modified[T](list: List[T]): List[Any] = {
    P09
      .pack(list)
      .map {
        case x :: Nil => x
        case ll @ (x :: _) => (ll.length, x)
        case Nil => Nil
      }
  }

}
