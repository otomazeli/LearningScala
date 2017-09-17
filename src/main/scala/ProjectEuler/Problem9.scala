package ProjectEuler

/**
  * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2
  *
  *   For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.
  *
  * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
  *
  */
object Problem9 {

  def equator(e: Int): Option[Int] = {
    val limit = (1 to e).find(n => n + math.sqrt(n) >= e).get
    val all_values = for {
      a <- 2 until limit
      b <- 1 until limit
      c = e - a - b
      if math.pow(a, 2) + math.pow(b, 2) == math.pow(c, 2)
    } yield a * b * c
    all_values.headOption
  }

}
