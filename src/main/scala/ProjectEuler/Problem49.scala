package ProjectEuler

/**
  * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
  *
  * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
  *
  * What 12-digit number do you form by concatenating the three terms in this sequence?
  *
  */
object Problem49 {

  def isPrime(number: Int): Boolean = {
    number match {
      case 1 => true
      case x => Nil == (2 to math.sqrt(number).toInt filter (y => x % y == 0))
    }
  }
  def sort(n: Int): Int                       = n.toString.toList.sortWith(_ < _).mkString.toInt
  def isConditional(n: Int, nn: Int): Boolean = isPrime(nn) && sort(nn) == sort(n)
  def isseq(n: Int): Boolean                  = isConditional(n, n + 3330) && isConditional(n, n + 6660)
  def mkSequence(n: Int): String              = List(n, n + 3330, n + 6660).mkString

}
