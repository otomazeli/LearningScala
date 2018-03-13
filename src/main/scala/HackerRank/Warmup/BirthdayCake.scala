package HackerRank.Warmup

object BirthdayCake {

  def birthdayCakeCandles(n: Int, ar: Array[Int]): Int = ar match {
    case x if x.isEmpty => 0
    case _              => ar.count(_ == ar.max)
  }

  //  def main(args: Array[String]) {
  //    val sc = new java.util.Scanner(System.in)
  //    var n = sc.nextInt()
  //    var ar = new Array[Int](n)
  //    for (ar_i <- 0 to n - 1) {
  //      ar(ar_i) = sc.nextInt()
  //    }
  //    val result = birthdayCakeCandles(n, ar)
  //    println(result)
  //  }

}
