package HackerRank.Warmup

object SimpleArrayBuffer {

  def simpleArraySum(n: Int, ar: Array[Int]): Int = {
    if (ar.isEmpty) 0 else ar.sum
  }

  //  def main(args: Array[String]) {
  //    val sc = new java.util.Scanner(System.in);
  //    var n  = sc.nextInt();
  //    var ar = new Array[Int](n);
  //    for (ar_i <- 0 to n - 1) {
  //      ar(ar_i) = sc.nextInt();
  //    }
  //    val result = simpleArraySum(n, ar);
  //    println(result)
  //  }
}
