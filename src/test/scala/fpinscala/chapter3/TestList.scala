package fpinscala.chapter3

import fpinscala.chapter3.List._
import org.scalatest._

class TestList extends FlatSpec with Matchers {

  "List.sum" should "sum" in {
    assert(sum(apply(1, 2, 3, 4, 5)) === 15)
  }

  "List.product" should "product" in {
    assert(product(apply()) === 1)
    assert(product(apply(1)) === 1)
    assert(product(apply(1)) === 1)
    assert(product(List(1, 2, 3, 4, 5)) === 120)
  }

  "List.sum2" should "sum" in {
    assert(sum2(Nil) === 0)
  }

  "List.sum3" should "sum" in {
    assert(sum3(Cons(1, Nil)) === 1)
  }

  "List.tail" should "tail" in {
    assert(tail(List(1, 2, 3, 4)) === List(2, 3, 4))
  }

  "List.setHead" should "setHead" in {
    assert(setHead(List(1, 2, 3, 4), 5) === List(5, 2, 3, 4))
  }

  "List.drop" should "drop" in {
    assert(drop(List(1, 2, 3), 10) === Nil)
    assert(drop(Nil, 10) === Nil)
    assert(drop(List(1, 2, 3), 1) === List(2, 3))
    assert(drop(List(1, 2, 3), 3) === Nil)
  }

  "List.dropWhile" should "dropWhile" in {
    assert(dropWhile(List(1, 2, 3, 4), (x: Int) => x > 5) === List(1, 2, 3, 4))
    assert(dropWhile(List(1, 2, 3, 4), (x: Int) => x < 5) === Nil)
    assert(dropWhile(List(1, 2, 3, 4), (x: Int) => x < 3) === List(3, 4))
  }

  "List.init" should "init" in {
    assert(init(List(1, 2, 3, 4)) === List(1, 2, 3))
    assert(init(List(1)) === Nil)
  }

  "List.foldLeft" should "foldleft" in {
    assert(foldLeft(List(1, 2, 3, 4), 0)(_ - _) === -10)
  }

  "List.reverse" should "reverse" in {
    assert(reverse(List(1, 2, 3, 4)) === List(4, 3, 2, 1))
    assert(reverse(Nil) === Nil)
  }

  "List.append" should "append" in {
    assert(append(Nil, Nil) === Nil)
    assert(append(Nil, List(1, 2, 3, 4)) === List(1, 2, 3, 4))
    assert(append(List(1, 2, 3, 4), Nil) === List(1, 2, 3, 4))
    assert(append(List(1, 2, 3), List(4, 5, 6)) === List(1, 2, 3, 4, 5, 6))
  }

  "List.filter" should "filter" in {
    val l = List(1, 2, 3, 4)
    assert(filter(l)(_ > 5) === Nil)
    assert(filter(l)(_ < 5) === l)
    assert(filter(l)(_ < 3) === List(1, 2))
  }

  "List.map" should "map something" in {
    val l = List(1, 2, 3, 4)
    assert(map(l)(_ + 1) === List(2, 3, 4, 5))
    assert(map(l)(_.toString) === List("1", "2", "3", "4"))
    assert(map(l)(math.pow(_, 2).toInt) === List(1, 4, 9, 16))
  }

  "List.flatMap" should "flatMap" in {
    val l = List(1, 2, 3, 4)
    assert(flatMap(l)(e => List(e, e)) === List(1, 1, 2, 2, 3, 3, 4, 4))
  }

  "List.zipWith" should "zipWith" in {
    assert(zipWith(List(1, 2, 3, 4), List(5, 6, 7, 8))(_ + _) === List(6, 8, 10, 12))
    assert(zipWith(List(1, 2, 3, 4), List(5, 6, 7, 8))(_ * _) === List(5, 12, 21, 32))
  }

  "List.hasSequence" should "hasSequence" in {
    assert(hasSubsequence(List(1, 2, 3, 4), List(2, 3)))
    assert(!hasSubsequence(List(1, 2, 3, 4), List(6, 7)))
    assert(hasSubsequence(List(1, 2, 3, 4), Nil))
    assert(hasSubsequence(List(1, 2, 3, 4), List(1, 2, 3, 4)))
    assert(!hasSubsequence(List(1, 2, 3, 4), List(1, 2, 3, 4, 5)))
    assert(!hasSubsequence(Nil, List(1, 2, 3, 4)))
    assert(hasSubsequence(Nil, Nil))
  }

}
