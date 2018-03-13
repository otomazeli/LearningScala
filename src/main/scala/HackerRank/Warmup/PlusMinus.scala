package HackerRank.Warmup

object PlusMinus {

  def plusMinus(arr: Array[Int]): Unit = {
    val b = arr match {
      case x if x.isEmpty => List(0, 0, 0)
      case _ =>
        val n = arr.length.toDouble
        val v = arr.foldLeft((0, 0, 0)) {
          case (x, y) =>
            y match {
              case z if z > 0 => (x._1 + 1, x._2, x._3)
              case z if z < 0 => (x._1, x._2 + 1, x._3)
              case _          => (x._1, x._2, x._3 + 1)
            }
        }
        List(v._1 / n, v._2 / n, v._3 / n)
    }
    b.foreach(println)
  }

  //  def main(args: Array[String]) {
  //    val sc = new java.util.Scanner(System.in);
  //    var n = sc.nextInt();
  //    var arr = new Array[Int](n);
  //    for (arr_i <- 0 to n - 1) {
  //      arr(arr_i) = sc.nextInt();
  //    }
  //    plusMinus(arr);
  //  }
}
