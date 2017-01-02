package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P09 extends App {

  // Pack consecutive duplicates of list elements into sublists.
  val inputList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  val expectedResult: Seq[List[Symbol]] = List(List('a, 'a, 'a, 'a),
                                               List('b),
                                               List('c, 'c),
                                               List('a, 'a),
                                               List('d),
                                               List('e, 'e, 'e, 'e))

  println("Input: " + inputList)

  def pack[T](list: List[T]): List[List[T]] = list match {
    case x :: xs =>
      (x +: xs.takeWhile(el => el == x)) +: pack(xs.dropWhile(el => el == x))
    case Nil => Nil
  }

  println("Output: " + pack(inputList))
  println("Check: " + (pack(inputList) == expectedResult))

}
