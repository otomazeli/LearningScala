package ProjectEuler

/**
  * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6
  * and 9. The sum of these multiples is 23.
  *
  * Find the sum of all the multiples of 3 or 5 below 1000.
  */
object Problem1 {

  @scala.annotation.tailrec
  def checker(a: Stream[Int], e: List[Int], max: Int): Int = {
    a match {
      case d if a.head == max => e.sum
      case b if a.head % 3 == 0 | a.head % 5 == 0 =>
        checker(a.tail, a.head :: e, max)
      case _ => checker(a.tail, e, max)
    }
  }

}
