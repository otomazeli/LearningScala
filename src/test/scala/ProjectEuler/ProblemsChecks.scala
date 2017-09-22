package ProjectEuler

import ProjectEuler.Problem1.checker
import ProjectEuler.Problem2.even_checker
import ProjectEuler.Problem25.findingLength
import ProjectEuler.Problem27.quadraticPrimes
import ProjectEuler.Problem29.distinctTerms
import ProjectEuler.Problem3.largestPrimeFactor
import ProjectEuler.Problem30.splitEqual
import ProjectEuler.Problem31.coinFinder
import ProjectEuler.Problem34.splitEquall
import ProjectEuler.Problem39.integerRightTriangles
import ProjectEuler.Problem4.{isPalindrome, maxPalindrome}
import ProjectEuler.Problem40.champernownesConstant
import ProjectEuler.Problem48.selfSumSquare
import ProjectEuler.Problem49.{isPrime, isseq, mkSequence}
import ProjectEuler.Problem5.smallestDivisor
import ProjectEuler.Problem52.multiplier
import ProjectEuler.Problem56.powerfulDigitSum
import ProjectEuler.Problem7.primes
import ProjectEuler.Problem8.adjacentProduct
import ProjectEuler.Problem9.equator
import ProjectEuler.Problem92.{splitString, squareDigitChains}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit Tests for Problems 1-10 - Project Euler
  */
class ProblemsChecks extends FlatSpec with Matchers {

  "Problem one" should "find the sum of all value less than a given number that are divisible by 5 or 3" in {
    // Generate an infinite of values
    lazy val range_values: Stream[Int] = 1 #:: 2 #::
      range_values.zip(range_values.tail).map { n =>
      n._2 + 1
    }
    // Assertions
    assert(checker(range_values, Nil, 10) === 23)
    assert(checker(range_values, Nil, 1000) === 233168)
  }

  "Problem two" should "find the sum of all primes less than a given number that are even" in {
    // Generate an infinite fibonacci sequence
    lazy val fibs: Stream[Int] = 0 #:: 1 #::
      fibs.zip(fibs.tail).map { n =>
      n._1 + n._2
    }
    // Assertions
    assert(even_checker(fibs, Nil, 90) === 44)
    assert(even_checker(fibs, Nil, 4000000) === 4613732)
  }

  "Problem three" should "find the max largest prime factor" in {
    // Assertions
    assert(largestPrimeFactor(13195) === 29)
    assert(largestPrimeFactor(BigInt(600851475143L)) === 6857)
  }

  "Problem four" should "isPalindrome" in {
    // Assertions
    assert(isPalindrome(101))
    assert(!isPalindrome(1871))
  }

  "Problem four b" should "maxPalindrome" in {
    // Assertions
    assert(maxPalindrome(0, 100) === 9009)
    assert(maxPalindrome(100, 999) === 906609)
  }

  "Problem five" should "smallestDivisor" in {
    // Assertions
    assert(smallestDivisor(List(1)) === 1)
    assert(smallestDivisor((1 to 10).toList) === 2520)
    assert(smallestDivisor((1 to 20).toList) === 232792560)
  }

  "Problem 7" should "find the 10001 st prime number" in {
    // Assertions
    assert(primes(5) === 13)
    assert(primes(10000) === 104743)
  }

  "Problem 8" should "string adjacent product finder" in {
    val myString =
      "7316717653133062491922511967442657474235534919493496983520" +
        "31277450632623957831801698480186947885184385861560789112" +
        "94949545950173795833195285320880551112540698747158523863" +
        "05071569329096329522744304355789664895044524452316173185" +
        "64030987111217223831136222989342338030813533627661428280" +
        "64444866452387493035890729629049156044077239071381051585" +
        "93079608667017242712188399879790879227492190169972088809" +
        "37766572733300105336788122023542180975125454059475224352" +
        "58490771167055601360483958644670632441572215539753697817" +
        "97784617406495514929086256932197846862248283972241375657" +
        "05605749026140797296865241453510047482166370484403199890" +
        "00889524345065854122758866688116427171479924442928230863" +
        "46567481391912316282458617866458359124566529476545682848" +
        "91288314260769004224219022671055626321111109370544217506" +
        "94165896040807198403850962455444362981230987879927244284" +
        "90918884580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725716362" +
        "69561882670428252483600823257530420752963450"
    // Assertions
    assert(adjacentProduct(myString, 4) === 5832)
  }

  "Problem 9" should "equal 31875000" in {
    // Assertions
    assert(equator(1000).get === 31875000)
  }

  "Problem 10" should "show the sum of primes less than 2M" in {
    // Assertions
    assert(primes.takeWhile(_ < 10).foldLeft(0L)(_ + _) === 17)
    assert(primes.takeWhile(_ < 2000000).foldLeft(0L)(_ + _) === 142913828922L)
  }

  "Problem 25" should "What is the index of the first term in the Fibonacci sequence to contain 1000 digits?" in {
    // Assertions
    assert(findingLength(3) === 12)
    assert(findingLength(1000) === 4782)
  }

  "Problem 27" should "Find the product of the coefficients, a and b, for the quadratic expression that produces " +
    "the maximum number of primes for consecutive values of n, starting with n=0." in {
    // Assertions
    assert(quadraticPrimes(1000, 1000)._2 === -59231)
  }

  "Problem 29" should "How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 " +
    "and 2 ≤ b ≤ 100?" in {
    // Assertions
    assert(distinctTerms(100, 100) === 9183)
  }

  "Problem 30" should "Find the sum of all the numbers that can be written as the sum of fifth " +
    "powers of their digits." in {
    // Assertions
    assert((2 to 1000000).flatMap(x => splitEqual(x, 5)).sum === 443839)
  }

  "Problem 31" should "How many different ways can £2 be made using any number of coins?" in {
    // Assertions
    assert(coinFinder(List(1, 2, 5, 10, 20, 50, 100, 200), 200) === 73682)
  }

  "Problem 34" should "Find the sum of all numbers which are equal to the sum of the factorial of their digits." in {
    // Assertions
    assert((3 to 2540160).flatMap(splitEquall).sum === 40730)
  }

  "Problem 39" should "For which value of p ≤ 1000, is the number of solutions maximised?" in {
    // Assertions
    assert(List.range(3, 1000).map(integerRightTriangles).max % 1000 === 840)
  }

  "Problem 40" should "If dn represents the nth digit of the fractional part, find the value " +
    "of the following expression. d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000" in {
    // Assertions
    assert(champernownesConstant(6) === 210)
  }

  "Problem 48" should "Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000." in {
    // Assertions
    assert(selfSumSquare(1000) === "9110846700")
  }

  "Problem 49" should "What 12-digit number do you form by concatenating the three terms in this sequence?" in {
    // Assertions
    assert(mkSequence((1488 to 3340).filter(isPrime).filter(isseq).head) === "296962999629")
  }

  "Problem 52" should "Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, " +
    "contain the same digits." in {
    // Assertions
    assert((3 to 1000000).flatMap(multiplier(_, 6)).headOption === Some(142857))
    assert(multiplier(125874, 2) === Some(125874))
  }

  "Problem 56" should "Considering natural numbers of the form, ab, where a, b < 100, what is the " +
    "maximum digital sum?" in {
    // Assertions
    assert(powerfulDigitSum(99) === 972)
  }

  "Problem 92" should "How many starting numbers below ten million will arrive at 89?" in {
    // Assertions
    assert(splitString(44) === 32)
    assert(splitString(1) === 1)
    assert(squareDigitChains(44) === 0)
    assert(squareDigitChains(85) === 1)
    assert(squareDigitChains(145) === 1)
    assert((2 to 10000000).par.map(squareDigitChains).sum === 8581146)
  }

}
