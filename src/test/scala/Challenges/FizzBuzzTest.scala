package Challenges

import org.scalatest._

class FizzBuzzTest extends FlatSpec with Matchers {

  "FizzBuzz.3" should "show 'Fizz'" in {
    assert(FizzBuzz(3) === "Fizz")
  }

  "FizzBuzz.15" should "show 'FizzBuzz'" in {
    assert(FizzBuzz(15) === "FizzBuzz")
  }

  "FizzBuzz.5" should "show 'Buzz'" in {
    assert(FizzBuzz(5) === "Buzz")
  }

  "FizzBuzz.Range" should "show sum" in {
    val applyRange =
      (1 to 5124).map(FizzBuzz(_)).groupBy(i => i).mapValues(_.size)
    assert(applyRange("Buzz") === 683)
    assert(applyRange("FizzBuzz") === 341)
    assert(applyRange("Fizz") === 1367)
  }

  "FizzBuzz.Negative" should "show 'Buzz'" in {
    assert(FizzBuzz(-5) === "Buzz")
  }

}
