package ProjectEuler

/**
  * A palindromic number reads the same both ways. The largest palindrome made from the
  * product of two 2-digit numbers is 9009 = 91 × 99.
  *
  * Find the largest palindrome made from the product of two 3-digit numbers.
  *
  */
object Problem4 {

  def isPalindrome(n: Int): Boolean = n.toString.reverse == n.toString

  def maxPalindrome(s: Int, e: Int): Int = {
    for {
      i <- s to e
      j <- i to e
      n = i * j
      if isPalindrome(n)
    } yield n
  }.max

}
