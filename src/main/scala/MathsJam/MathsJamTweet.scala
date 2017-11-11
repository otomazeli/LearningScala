package MathsJam

object MathsJamTweet {
  // Original Tweet: https://twitter.com/tombutton/status/929358013990866945

  /** Check if a value is a Prime Number
    *
    * @param n  Value to Check
    * @return   Boolean
    */
  def isPrimeForBigInt(n: BigInt): Boolean = {

    def ceiling: BigInt = {
      def f(a: BigInt): Stream[BigInt] = a #:: f(a + 1)
      f(BigInt(1)).dropWhile(_.pow(2) < n)(0)
    }
    Range.BigInt(BigInt(2), ceiling, BigInt(1)) forall (x => n % x != 0)
  }

  /** Check the Combinations as described in the Tweet
    *
    * @param x
    * @return
    */
  def checkProblem(x: BigInt): Boolean = {
    x match {
      case k
          if isPrimeForBigInt(k) & isPrimeForBigInt((k + 2) / 3) &
            isPrimeForBigInt((k + 1) / 2) => // & isPrimeForBigInt((k + 3) / 4)
        true
      case _ => false
    }
  }

  def main(args: Array[String]): Unit = {
    // Specify a range to check
    val rangeValues = Stream.range[BigInt](BigInt(2018), BigInt(999999999999999999L))

    // Display the result
    println(s"First value: ${rangeValues.takeWhile(checkProblem)}")
  }

}
