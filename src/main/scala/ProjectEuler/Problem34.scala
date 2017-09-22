package ProjectEuler

/**
  * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
  *
  * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
  *
  * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
  *
  */
object Problem34 {

  def factorial(n: Int): BigInt = (BigInt(1) to BigInt(n)).product

  def splitEquall(v: Int): Option[Int] = {
    v match {
      case k
          if v == v.toString
            .map(_.asDigit)
            .map(factorial(_).toInt)
            .sum =>
        Some(k)
      case _ => None
    }
  }

}
