package ProjectEuler

/**
  * 2520 is the smallest number that can be divided by each of the numbers
  * from 1 to 10 without any remainder.
  *
  * What is the smallest positive number that is evenly divisible by all of
  * the numbers from 1 to 20?
  *
  */
object Problem5 {

  def smallestDivisor(d: List[Int]): Int = {
    def go(n: Int): Int = {
      if (d forall (n % _ == 0)) n
      else go(n + 1)
    }
    go(1)
  }

}
