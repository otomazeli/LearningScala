package ProjectEuler

/**
  * A number chain is created by continuously adding the square of the digits in a number to form a new number
  * until it has been seen before.
  *
  * For example,
  *
  * 44 → 32 → 13 → 10 → 1 → 1
  * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
  *
  * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is
  * that EVERY starting number will eventually arrive at 1 or 89.
  *
  * How many starting numbers below ten million will arrive at 89?
  *
  */
object Problem92 {

  def splitString(n: Int): Int = {
    n.toString.toList.map(x => math.pow(x.asDigit, 2)).sum.toInt
  }

  @scala.annotation.tailrec
  def squareDigitChains(n: Int): Int = {
    splitString(n) match {
      case 1  => 0
      case 89 => 1
      case _  => squareDigitChains(splitString(n))
    }
  }

}