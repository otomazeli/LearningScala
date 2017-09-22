package ProjectEuler

/**
  * A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost
  * unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits
  * in each number is only 1.
  *
  * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
  *
  */
object Problem56 {

  def powerfulDigitSum(n: Int): Int = {
    (1 to n)
      .flatMap(x => (1 to n).map(k => BigInt(x).pow(k).toString.toList.map(_.asDigit).sum))
      .max
  }

}
