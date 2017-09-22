package Challenges

/**
  * Well-known challenge - FizzBuzz
  */
object FizzBuzz {

  /**
    * The FizzBuzz Calculator
    */
  def apply(i: Int): String = i match {
    case a if a % 3 == 0 && a % 5 == 0 => "FizzBuzz"
    case b if b % 3 == 0 => "Fizz"
    case c if c % 5 == 0 => "Buzz"
    case _ => i.toString
  }

}
