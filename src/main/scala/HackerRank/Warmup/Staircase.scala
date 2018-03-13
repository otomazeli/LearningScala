package HackerRank.Warmup

object Staircase {

  def staircase(n: Int): Unit = {
    for (i <- 1 to n) {
      println(" " * (n - i) + "#" * i)
    }
  }

  //  def main(args: Array[String]) {
  //    val sc = new java.util.Scanner(System.in)
  //    var n  = sc.nextInt()
  //    staircase(n)
  //  }
}
