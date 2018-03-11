package HackerRank.Warmup

object MiniMaxSum {

  def miniMaxSum(arr: Array[Int]): Unit = {
    println(
      arr
        .map(_.toLong)
        .combinations(arr.length)
        .map(_.sum)
        .foldLeft(Long.MaxValue, Long.MinValue) {
          case ((mn, mx), i) => (i min mn, i max mx)
        }
        .productIterator
        .toList
        .mkString(" "))
  }

  //  def main(args: Array[String]) {
  //    val sc = new java.util.Scanner(System.in)
  //    var arr = new Array[Int](5)
  //    for (arr_i <- 0 to 5 - 1) {
  //      arr(arr_i) = sc.nextInt()
  //    }
  //    miniMaxSum(arr)
  //  }

}
