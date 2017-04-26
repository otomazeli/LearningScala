package fpinscala.chapter2

import fpinscala.chapter2.myModule._
import org.scalatest._

class myModuleTest extends FlatSpec with Matchers {

  "fib.5" should "show '8'" in {
    assert(fib(5) == 8)
  }

  "fib.7" should "show '21'" in {
    assert(fib(7) == 21)
  }

  "factorial.5" should "show '120'" in {
    assert(factorial(5) == 120)
  }

  "factorial.7" should "show '5040'" in {
    assert(factorial(7) == 5040)
  }

  "findFirst.v1" should "show...4" in {
    val intArray = Array(1, 3, 4, 5, 100)
    assert(findFirst(intArray, 100.equals) == 4)
  }

  "findFirst.v2" should "show...2" in {
    val strArray = Array("Dan", "Dixey", "Scala")
    assert(findFirst(strArray, (s: String) => s.equals("Scala")) == 2)
  }

  "isSorted.v1" should "show...true" in {
    val intArray = Array(1, 3, 4, 5, 100)
    assert(isSorted(intArray, (a: Int, b: Int) => a > b))
  }

  "isSorted.v2" should "show...false" in {
    val intArray = Array(10, 3, 4, 5, 101)
    assert(!isSorted(intArray, (a: Int, b: Int) => a > b))
  }

  "myArrayCounter.v1" should "show...3" in {
    val intArray = Array(1, 3, 4, 5, 100, 3, 4, 4)
    assert(myArrayCounter(intArray, 4.equals) == 3)
  }

  "myArrayCounter.v2" should "show...100" in {
    val intArray = Array.fill(100)(3)
    assert(myArrayCounter(intArray, 3.equals) == 100)
  }

  "currying" should "show..." in {
    val f: (Int, Int) => Int = (a: Int, b: Int) => a + b
    val g = curry(f)(2)
    assert(g(3) == f(2, 3))
  }

  "un-currying" should "show..." in {
    val f = (a: Int) => (b: Int) => a + b
    val g = uncurry(f)
    assert(g(2, 3) == f(2)(3))
  }

  "compose.book" should "show..." in {
    val f: String => Boolean = _.length == 1
    val g: Int => String = _.toString
    assert(composeBook(f, g)(1) == f(g(1)))
    assert(composeBook(f, g)(10) == f(g(10)))
  }

}

