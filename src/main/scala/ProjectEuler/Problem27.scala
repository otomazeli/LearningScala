package ProjectEuler

/**
  * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number
  *     of primes for consecutive values of n, starting with n=0.
  *
  */
object Problem27 {

  // Check if Value is a Prime Number
  def isPrime(n: Int, ps: Stream[Int]): Boolean = ps.view.takeWhile(_ <= n).contains(n)

  def quadraticPrimes(a: Int, b: Int): (Int, Int) = {
    // Prime Number Generator
    lazy val ps: Stream[Int] = 2 #:: Stream
      .from(3)
      .filter(i => ps.takeWhile(j => j * j <= i).forall(i % _ > 0))

    // Try all - Include Negatives due to Mod
    val ns = (-999 until 999).flatMap { a =>
      (-1000 until 1000).map(
        b =>
          (a,
           b,
           (0 to 1000).view
             .takeWhile(n => isPrime(n * n + a * n + b, ps))
             .length))
    }
    val t = ns.reduceLeft((a, b) => if (a._3 > b._3) a else b)
    (t._3, t._1 * t._2)
  }

}
