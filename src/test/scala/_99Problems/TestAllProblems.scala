package _99Problems

import _99Problems.Arithmetic._
import _99Problems.WorkingWithLists._
import org.scalatest._

class TestAllProblems extends FlatSpec with Matchers {

  "P01" should "lastRecursion" in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P01.lastRecursion(list) === list.last)
    assert(P01.lastRecursion(list) === 8)
  }

  "P02" should "penultimate" in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P02.penultimate(list) === list.takeRight(2).head)
    assert(P02.penultimate(list) === list.init.last)
  }

  "P03" should "kthRecursive" in {
    val list = List(1, 1, 2, 3, 5, 8)
    P03.kthRecursive(list, 5) === list(5)
  }

  "P04" should "lengthRecursive" in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P04.lengthRecursive(list) === list.length)
  }

  "P05" should "reverseRecursive" in {
    val list = List(1, 1, 2, 3, 5, 8)
    assert(P05.reverseRecursive(list) === list.reverse)
  }

  "P06" should "isPalindrome" in {
    val exampleList = List(1, 2, 3, 2, 1)
    val exampleList2 = List(1, 2)
    assert(P06.isPalindrome(exampleList))
    assert(!P06.isPalindrome(exampleList2))
  }

  "P07" should "flatten" in {
    val inputList = List(List(1, 1), 2, List(3, List(5, 8)))
    val expectResult = List(1, 1, 2, 3, 5, 8)
    assert(P07.flatten(inputList) === expectResult)
  }

  "P08" should "compress" in {
    val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expectedResult = List('a, 'b, 'c, 'a, 'd, 'e)
    assert(P08.compress(input) === expectedResult)
  }

  "P09" should "pack" in {
    val inputList =
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expectedResult: Seq[List[Symbol]] = List(List('a, 'a, 'a, 'a),
                                                 List('b),
                                                 List('c, 'c),
                                                 List('a, 'a),
                                                 List('d),
                                                 List('e, 'e, 'e, 'e))
    assert(P09.pack(inputList) === expectedResult)
  }

  "P10" should "encode" in {
    // Run-length encoding of a list.
    val inputList =
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    // Use the result of problem P09 to implement the so-called run-length encoding data compression method.
    // Consecutive duplicates of elements are encoded as tuples (N, E) where N is
    // the number of duplicates of the element E.
    val expectedResult: Seq[(Int, Symbol)] =
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    assert(P10.encode(inputList) === expectedResult)
  }

  "P11" should "encode_modified" in {
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

  "P12" should "decode" in {
    // Decode a run-length encoded list.
    // Given a run-length code list generated as specified in problem
    // P10, construct its uncompressed version.
    val inputList = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val expectedResult: Seq[Symbol] =
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    assert(P12.decode(inputList) === expectedResult)
  }

  "P13" should "encodeDirectSpan" in {
    // Run-length encoding of a list (direct solution).
    // Implement the so-called run-length encoding data compression method
    // directly. I.e. don't use other methods you've written (like P09's pack); do
    // all the work directly.
    val inputList =
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expectedResult: Seq[(Int, Symbol)] =
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    assert(P13.encodeDirectSpan(inputList) === expectedResult)
  }

  "P14" should "duplicate" in {
    // Duplicate the elements of a list.
    val inputList = List('a, 'b, 'c, 'c, 'd)
    val expectedResult: List[Symbol] =
      List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    assert(P14.duplicate(inputList) === expectedResult)
  }

  "P15" should "duplicateN" in {
    // Duplicate the elements of a list a given number of times.
    val inputList = List('a, 'b, 'c, 'c, 'd)
    val expectedResult: List[Symbol] =
      List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    assert(P15.duplicateN(3, inputList) === expectedResult)
  }

  "P16" should "dropN" in {
    // Drop every Nth element from a list.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult: List[Symbol] =
      List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    assert(P16.dropN(3, inputList) === expectedResult)
  }

  "P17" should "splitN" in {
    // Split a list into two parts.
    // Drop every Nth element from a list.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult =
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    assert(P17.splitN(3, inputList) === expectedResult)
  }

  "P18" should "slice" in {
    // Extract a slice from a list.
    // Given two indices, I and K, the slice is the list containing the elements
    // from and including the Ith element up to but not including the Kth element
    // of the original list. Start counting the elements with 0.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult = List('d, 'e, 'f, 'g)
    assert(P18.slice(3, 7, inputList) === expectedResult)
  }

  "P19" should "rotate" in {
    // Rotate a list N places to the left.
    val inputList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val expectedResult = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    assert(P19.rotate(3, inputList) === expectedResult)
  }

  "P20" should "removeAt" in {
    // Remove the Kth element from a list.
    // Return the list and the removed element in a Tuple.
    // Elements are numbered from 0
    val inputList = List('a, 'b, 'c, 'd)
    val expectedResult = (List('a, 'c, 'd), 'b)
    assert(P20.removeAt(1, inputList) === expectedResult)
  }

  "P21" should "insertAt" in {
    // Insert an element at a given position into a list.
    val inputList = List('a, 'b, 'c, 'd)
    val expectedResult = List('a, 'new, 'b, 'c, 'd)
    assert(P21.insertAt('new, 1, inputList) === expectedResult)
  }

  "P22" should "tailRange" in {
    assert(P22.range(4, 9) === List(4, 5, 6, 7, 8, 9))
    assert(P22.tailRange(4, 9) === List(4, 5, 6, 7, 8, 9))
  }

  "P23" should "randomSelect" in {
    assert(P23.randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)).size === 3)
  }

  "P24" should "lotto" in {
    assert(P24.lotto(6, 49).distinct.size === 6)
  }

  "P25" should "lotto" in {
    assert(
      P25.randomPerm(List(4, 5, 6, 7, 8, 9)).toSet === List(4, 5, 6, 7, 8,
        9).toSet)
  }

  "P26" should "combinations" in {
    assert(P26.combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)).size === 20)
  }

  "P27" should "group3" in {
    assert(
      P27
        .group3(
          List("Aldo",
               "Beat",
               "Carla",
               "David",
               "Evi",
               "Flip",
               "Gary",
               "Hugo",
               "Ida"))
        .size === 1260)
    assert(
      P27
        .group(List("Aldo",
                    "Beat",
                    "Carla",
                    "David",
                    "Evi",
                    "Flip",
                    "Gary",
                    "Hugo",
                    "Ida"),
               List(2, 2, 5))
        .size === 756)
  }

  "P28" should "lsort AND lsortFreq" in {
    assert(
      P28.lsort(
        List(List('a, 'b, 'c),
             List('d, 'e),
             List('f, 'g, 'h),
             List('d, 'e),
             List('i, 'j, 'k, 'l),
             List('m, 'n),
             List('o))) ===
        List(List('o),
             List('d, 'e),
             List('d, 'e),
             List('m, 'n),
             List('a, 'b, 'c),
             List('f, 'g, 'h),
             List('i, 'j, 'k, 'l))
    )
    assert(
      P28.lsortFreq(
        List(List('a, 'b, 'c),
             List('d, 'e),
             List('f, 'g, 'h),
             List('d, 'e),
             List('i, 'j, 'k, 'l),
             List('m, 'n),
             List('o))) ===
        List(List('i, 'j, 'k, 'l),
             List('o),
             List('a, 'b, 'c),
             List('f, 'g, 'h),
             List('d, 'e),
             List('d, 'e),
             List('m, 'n))
    )
  }

  "P31" should "isPrime" in {
    val x = new S99Int(7)
    assert(x.isPrime)
  }

  "P32" should "gcd(36, 63)" in {
    val x = new S99Int(7)
    assert(x.gcd(36, 63) === 9)
  }

  "P33" should "35.isCoprimeTo(64)" in {
    val x = new S99Int(35)
    assert(x.isCoprimeTo(64))
  }

  "P34" should "10.totient res0: Int = 4" in {
    val x = new S99Int(10)
    assert(x.totient == 4)
  }

}
