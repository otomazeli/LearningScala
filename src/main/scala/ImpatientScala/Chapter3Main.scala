package ImpatientScala

import scala.collection.immutable.Seq

/**
  * Working with Arrays - Chapter 3
  */
object Chapter3Main extends App {

  println("Prelims.")
  // Multi-dimensional arrays
  val matrix = Array.ofDim[Double](3, 4)
  // Ragged Arrays
  val triangle = new Array[Array[Int]](10)
  for (i <- triangle.indices)
    triangle(i) = new Array[Int](i + 1)

  println(
    "1. Write a code snippet that sets a to an array of n random integers" +
      " between 0 (inclusive) and n (exclusive).")
  val n = 20
  val a1: Array[Int] = new Array[Int](n)
  for (i <- a1.indices) a1(i) = scala.util.Random.nextInt(n)
  println(a1.mkString("< ", ", ", " >"))

  println(
    "2. Write a loop that swaps adjacent elements of an array of " +
      "integers. For example Array(1,2,3,4,5) becomes Array(2,1,4,3,5).")
  val a2: Array[Int] = a1
  for (i <- 1 until (a2.length, 2)) {
    val t = a2(i - 1)
    a2(i - 1) = a2(i)
    a2(i) = t
  }
  println(a2.mkString("< ", ", ", " >"))

  println(
    "3. Repeat the preceding assignment, but produce a new array " +
      "with the swapped values. Use for yield.")
  def swapAdj(a: Array[Int]): Seq[Int] = {
    for (i <- a.indices)
      yield
        if (i % 2 == 0)
          if (i < a.length - 1)
            a(i + 1)
          else
            a(i)
        else a(i - 1)
  }
  val a3 = swapAdj(a1)
  println(a3.mkString("< ", ", ", " >"))

  println(
    "4. Given an array of integers, produce a new array that contains " +
      "all positive values of the original array, in their original order, followed " +
      "by all values that are zero or negative, in their original order")
  val a4 = Array(1, 2, 4, 5, -1, 0, -13, -4, -2)
  def positiveNegativeChanged(a: Array[Int]): Array[Int] = {
    a.filter(_ > 0).sortWith(_ > _) ++ a.filter(_ <= 0).sortWith(_ > _)
  }
  def positiveNegativeUnChanged(a: Array[Int]): Array[Int] = {
    a.filter(_ > 0) ++ a.filter(_ <= 0)
  }
  println(
    s"Changed: ${positiveNegativeChanged(a4).mkString("< ", ", ", " >")}")
  println(
    s"UnChanged: ${positiveNegativeUnChanged(a4).mkString("< ", ", ", " >")}")

}
