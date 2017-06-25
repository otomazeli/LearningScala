package _99Problems

import org.scalatest._

class TestAllProblems extends FlatSpec with Matchers {

  "P01" should "show ..." in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P01.lastRecursion(list) === list.last)
    assert(P01.lastRecursion(list) === 8)
  }

  "P02" should "show ..." in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P02.penultimate(list) === list.takeRight(2).head)
    assert(P02.penultimate(list) === list.init.last)
  }

  "P03" should "show..." in {
    val list = List(1, 1, 2, 3, 5, 8)
    P03.kthRecursive(list, 5) === list(5)
  }

  "P04" should "show..." in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P04.lengthRecursive(list) === list.length)
  }

  "P05" should "show..." in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P05.reverseRecursive(list) === list.reverse)
  }

  "P06" should "show..." in {
    val exampleList = List(1, 2, 3, 2, 1)
    val exampleList2 = List(1, 2)
    assert(P06.isPalindrome(exampleList))
    assert(!P06.isPalindrome(exampleList2))
  }

  "P07" should "show..." in {
    val inputList = List(List(1, 1), 2, List(3, List(5, 8)))
    val expectResult = List(1, 1, 2, 3, 5, 8)
    assert(P07.flatten(inputList) === expectResult)
  }

  "P08" should "show..." in {
    val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expectedResult = List('a, 'b, 'c, 'a, 'd, 'e)
    assert(P08.compress(input) === expectedResult)
  }

  "P09" should "show..." in {
    val inputList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expectedResult: Seq[List[Symbol]] = List(List('a, 'a, 'a, 'a),
      List('b),
      List('c, 'c),
      List('a, 'a),
      List('d),
      List('e, 'e, 'e, 'e))
    assert(P09.pack(inputList) === expectedResult)
  }

  "P10" should "show..." in {
    // Run-length encoding of a list.
    val inputList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    // Use the result of problem P09 to implement the so-called run-length encoding data compression method.
    // Consecutive duplicates of elements are encoded as tuples (N, E) where N is
    // the number of duplicates of the element E.
    val expectedResult: Seq[(Int, Symbol)] =
    List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    assert(P10.encode(inputList) === expectedResult)
  }

  "P11" should "show..." in {
    // Modified run-length encoding.
    // Modify the result of problem P10 in such a way that if an element has no
    // duplicates it is simply copied into the result list. Only elements
    // with duplicates are transferred as (N, E) terms.
    val inputList =
    List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expectedResult: Seq[Serializable] =
      List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
    assert(P11.encode_modified(inputList) === expectedResult)
  }

  "P12" should "show..." in {
    // Decode a run-length encoded list.
    // Given a run-length code list generated as specified in problem
    // P10, construct its uncompressed version.
    val inputList = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val expectedResult: Seq[Symbol] =
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    assert(P12.decode(inputList) === expectedResult)
  }

  "P13" should "show..." in {
    // Run-length encoding of a list (direct solution).
    // Implement the so-called run-length encoding data compression method
    // directly. I.e. don't use other methods you've written (like P09's pack); do
    // all the work directly.
    val inputList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expectedResult: Seq[(Int, Symbol)] =
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    assert(P13.encodeDirectSpan(inputList) === expectedResult)
  }

  "P14" should "show..." in {
    // Duplicate the elements of a list.
    val inputList = List('a, 'b, 'c, 'c, 'd)
    val expectedResult: List[Symbol] =
      List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    assert(P14.duplicate(inputList) === expectedResult)
  }

  "P15" should "show..." in {
    // Duplicate the elements of a list a given number of times.
    val inputList = List('a, 'b, 'c, 'c, 'd)
    val expectedResult: List[Symbol] =
      List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    assert(P15.duplicateN(3, inputList) === expectedResult)
  }

  "P16" should "show..." in {
    // Drop every Nth element from a list.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult: List[Symbol] =
      List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    assert(P16.dropN(3, inputList) === expectedResult)
  }

  "P17" should "show..." in {
    // Split a list into two parts.
    // Drop every Nth element from a list.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult =
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    assert(P17.splitN(3, inputList) === expectedResult)
  }

  "P18" should "show..." in {
    // Extract a slice from a list.
    // Given two indices, I and K, the slice is the list containing the elements
    // from and including the Ith element up to but not including the Kth element
    // of the original list. Start counting the elements with 0.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult = List('d, 'e, 'f, 'g)
    assert(P18.slice(3, 7, inputList) === expectedResult)
  }

  "P19" should "show..." in {
    // Rotate a list N places to the left.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    assert(P19.rotate(3, inputList) === expectedResult)
  }

  "P20" should "show..." in {
    // Remove the Kth element from a list.
    // Return the list and the removed element in a Tuple.
    // Elements are numbered from 0
    val inputList = List('a, 'b, 'c, 'd)
    val expectedResult = (List('a, 'c, 'd), 'b)
    assert(P20.removeAt(1, inputList) === expectedResult)
  }

  "P21" should "show..." in {
    // Insert an element at a given position into a list.
    val inputList = List('a, 'b, 'c, 'd)
    val expectedResult = List('a, 'new, 'b, 'c, 'd)
    assert(P21.insertAt('new, 1, inputList) === expectedResult)
  }
}

