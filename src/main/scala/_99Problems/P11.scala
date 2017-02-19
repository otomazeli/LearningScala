package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P11 extends App {

  // Modified run-length encoding.
  // Modify the result of problem P10 in such a way that if an element has no
  // duplicates it is simply copied into the result list. Only elements
  // with duplicates are transferred as (N, E) terms.
  val inputList =
    List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  val expectedResult: Seq[Serializable] =
    List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))

  println("Input: " + inputList)

  def encode_modified[T](list: List[T]): List[Any] = {
    P09
      .pack(list)
      .map {
        case x :: Nil => x
        case ll @ (x :: _) => (ll.length, x)
        case Nil => Nil
      }
  }

  println("Output: " + encode_modified(inputList))
  println("Check: " + (encode_modified(inputList) == expectedResult))

}
