package HackerRank.Warmup

import scala.math.abs

object DiagonalDifference {

  def diagonalDifference(matrix: Array[Array[Int]]): Int = {
    require(matrix.length > 1)
    require(matrix.length == matrix.head.length)

    val n  = matrix.length
    val d1 = (for { i <- 0 until n } yield matrix(i)(i)).sum
    val d2 = (for { i <- (0 until n).reverse } yield matrix(i)(n - 1 - i)).sum
    abs(d1 - d2)
  }

  //  def main(args: Array[String]) {
  //    val sc = new java.util.Scanner(System.in)
  //    var n = sc.nextInt()
  //    var a = Array.ofDim[Int](n, n)
  //    for (a_i <- 0 to n - 1) {
  //      for (a_j <- 0 to n - 1) {
  //        a(a_i)(a_j) = sc.nextInt()
  //      }
  //    }
  //    val result = diagonalDifference(a)
  //    println(result)
  //  }
}
