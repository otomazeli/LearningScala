package ProjectEuler

/**
  * The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
  *
  * Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
  *
  */
object Problem48 {

  def selfSumSquare(n: Int): String = {
    (1 to n map (a => BigInt(a).pow(a))).sum.toString.takeRight(10)
  }

}
