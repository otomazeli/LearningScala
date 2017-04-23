package Challenges

/**
  * Well-known challenge - FizzBuzz
  */
object FizzBuzz extends App {

  /**
    * The FizzBuzz Calculator
    */
  def apply(i: Int): String = {
    i match {
      case a if a % 3 == 0 && a % 5 == 0 => "FizzBuzz"
      case b if b % 3 == 0 => "Fizz"
      case c if c % 5 == 0 => "Buzz"
      case _ => i.toString
    }
  }

  //  /**
  //    * Apply the FuzzBuzz calculator to a Scalar Value
  //    */
  //  println(s"Value = 5 => ${FizzBuzz(5)}")
  //
  //  /**
  //    * Apply the FuzzBuzz calculator to a Range
  //    */
  //  println(s"Range -5 to 25 => ${(1 to 5124).map(FizzBuzz(_))}")
  //
  //  /**
  //    * Apply the FuzzBuzz calculator to a negative Scalar Value
  //    */
  //  println(s"Value = -5 => ${FizzBuzz(-5)}")
  //
  //  /**
  //    * Count the Number of Fizz, Buzz and FizzBuzz in Range
  //    */
  //  val rng = (1 to 5124).map(FizzBuzz(_))
  //  println(
  //    rng.par
  //      .filter(_.contains("zz"))
  //      .groupBy(i => i)
  //      .mapValues(_.size)
  //      .
  //      // Tuple: (Name, Count, Total Count, Percentage)
  //      map(x => (x._1, x._2, rng.length, x._2 * 100.0 / rng.length)))

}
