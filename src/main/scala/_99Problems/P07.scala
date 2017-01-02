package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P07 extends App {

  // Flatten a nested list structure.
  val inputList: List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
  val expectResult = List(1, 1, 2, 3, 5, 8)

  println("Input: " + inputList)

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    /* this is an example of pattern matching on type, here
     * the code says 'if this item is itself a list'
     */
    case ms: List[_] => flatten(ms)
    // this matches any other item
    case e => List(e)
  }

  println("Output function: " + flatten(inputList))
  println("Check: " + (flatten(inputList) == expectResult))

}
