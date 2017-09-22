package ProjectEuler

/**
  * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
  *
  * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
  *
  */
object Problem52 {

  def sortedString(s: Int): String = s.toString.toList.sortWith(_ < _).mkString
  def multiplier(n: Int, m: Int): Option[Int] = {
    val lst = (1 to m).map(k => sortedString(k * n))
    if (lst.tail.forall(_ == lst.head)) Some(n)
    else None
  }

}
