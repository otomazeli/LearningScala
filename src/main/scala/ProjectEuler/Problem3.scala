package ProjectEuler

/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143 ?
  *
  */
object Problem3 {

  def largestPrimeFactor(b: BigInt): BigInt = {
    @scala.annotation.tailrec
    def loop(f: BigInt, n: BigInt): BigInt =
      if (f == n) n
      else if (n % f == 0) loop(f, n / f)
      else loop(f + 1, n)
    loop(BigInt(2), b)
  }

}
