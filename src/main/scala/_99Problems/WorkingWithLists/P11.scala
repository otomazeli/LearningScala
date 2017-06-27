package _99Problems.WorkingWithLists

/**
  * Modified run-length encoding.
  */
object P11 {

  def encode_modified[T](list: List[T]): List[Any] = {
    P09
      .pack(list)
      .map {
        case x :: Nil      => x
        case ll @ (x :: _) => (ll.length, x)
        case Nil           => Nil
      }
  }

}
