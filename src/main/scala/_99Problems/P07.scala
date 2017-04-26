package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P07 {

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    /* this is an example of pattern matching on type, here
     * the code says 'if this item is itself a list'
     */
    case ms: List[_] => flatten(ms)
    // this matches any other item
    case e => List(e)
  }

}
