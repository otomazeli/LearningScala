package _99Problems.Arithmetic

import scala.language.implicitConversions

class S99Int(val i: Int) {

  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)

  // P31
  // Determine whether a given integer number is prime.
  final def isPrime: Boolean = i match {
    case 1 => false
    case _ => !Stream.range(2, i).exists(i % _ == 0)
  }

  // P32
  // Determine the greatest common divisor of two positive
  //      integer numbers. Use Euclid's algorithm.
  @scala.annotation.tailrec
  final def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  // P33
  // Determine whether two positive integer numbers are coprime.
  // Two numbers are coprime if their greatest common divisor equals 1.
  def isCoprimeTo(b: Int): Boolean = {
    gcd(i, b) match {
      case 1 => true
      case _ => false
    }
  }

  // P34
  // Euler's so-called totient function phi(m) is defined as the number
  // of positive integers r (1 <= r <= m) that are coprime to m.
  def totient: Int = (1 to i).count(_.isCoprimeTo(i))

}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
}
