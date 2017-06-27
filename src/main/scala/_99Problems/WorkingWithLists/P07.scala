package _99Problems.WorkingWithLists

/**
  * Flatten a nested list structure.
  */
object P07 {

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e           => List(e)
  }

}
