package _99Problems.WorkingWithLists

/**
  * Extract a slice from a list.
  */
object P18 {

  def slice[T](start: Int, end: Int, list: List[T]): List[T] =
    list.slice(start, end)

}
