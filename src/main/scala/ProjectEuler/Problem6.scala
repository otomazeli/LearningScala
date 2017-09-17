package ProjectEuler

/**
  * The sum of the squares of the first ten natural numbers is,
  *     1^2 + 2^2 + ... + 102 = 385
  *
  * The square of the sum of the first ten natural numbers is,
  *     (1 + 2 + ... + 10)^2 = 55^2 = 3025
  *
  * Hence the difference between the sum of the squares of the first ten natural numbers
  * and the square of the sum is 3025 − 385 = 2640.
  *
  * Find the difference between the sum of the squares of the first one hundred natural
  * numbers and the square of the sum.
  *
  */
object Problem6 {

  def differenceCalc(a: List[Int]): Int = {
    val sumSquare: Int = a.map(v => math.pow(v, 2)).sum.toInt
    val squareSum: Int = math.pow(a.sum, 2).toInt
    sumSquare - squareSum
  }

}
