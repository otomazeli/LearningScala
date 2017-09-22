package ProjectEuler

/**
  * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
  *
  * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
  *
  */
object Problem30 {

  def splitEqual(v: Int, pow: Int): Option[Int] = {
    v match {
      case k
          if v == v.toString
            .map(_.asDigit)
            .map(math.pow(_, pow).toInt)
            .sum =>
        Some(k)
      case _ => None
    }
  }

}
