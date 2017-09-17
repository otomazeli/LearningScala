package ProjectEuler

import ProjectEuler.Problem1.checker
import ProjectEuler.Problem2.even_checker
import ProjectEuler.Problem3.largestPrimeFactor
import ProjectEuler.Problem4.{isPalindrome, maxPalindrome}
import ProjectEuler.Problem5.smallestDivisor
import ProjectEuler.Problem7.primes
import ProjectEuler.Problem8.adjacentProduct
import ProjectEuler.Problem9.equator
import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit Tests for Problems 1-10 - Project Euler
  */
class Problems1to10 extends FlatSpec with Matchers {

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

  //  "Problem six" should "differenceCalc" in {
  //    // Assertions
  //    assert(differenceCalc((1 to 10).toList) === 2640)
  //    assert(differenceCalc((1 to 100).toList) == 25164150)
  //  }

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
    //    assert(adjacentProduct(myString, 13) === 23514624000L)
  }

  "Problem 9" should "equal 31875000" in {
    // Assertions
    assert(equator(1000).get === 31875000)
  }

  "Problem 10" should "show the sum of primes less than 2M" in {
    assert(primes.takeWhile(_ < 10).foldLeft(0L)(_ + _) === 17)
    assert(primes.takeWhile(_ < 2000000).foldLeft(0L)(_ + _) === 142913828922L)
  }

}
