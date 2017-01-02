package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P16 extends App {

  // Drop every Nth element from a list.
  val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val expectedResult: List[Symbol] =
    List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

  println("Input: " + inputList)

  def dropN[T](n: Int, list: List[T]): List[T] = {
    def drop(list: List[T], n: Int, index: Int): List[T] = {
      list match {
        case x :: xs if index % n != 0 => x +: drop(xs, n, index + 1)
        case x :: xs if index % n == 0 => drop(xs, n, index + 1)
        case _ => Nil
      }
    }

    if (n == 0) list else drop(list, n, 1)
  }

  println("Output: " + dropN(3, inputList))
  println("Check: " + (dropN(3, inputList) == expectedResult))

}
