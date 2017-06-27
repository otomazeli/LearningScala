package _99Problems.WorkingWithLists

/**
  * Create a list containing all integers within a given range.
  */
object P22 {

  def range(start: Int, end: Int): List[Int] = List.range(start, end + 1)

  @scala.annotation.tailrec
  def tailRange(a: Int, b: Int, acc: List[Int] = Nil): List[Int] =
    if (b >= a) tailRange(a, b - 1, b :: acc)
    else acc
}
