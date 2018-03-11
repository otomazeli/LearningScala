package HackerRank.Warmup

object CompareTheTriplets {

  def comparison(a: Int, b: Int): (Int, Int) = a match {
    case x if x > b => (1, 0)
    case x if x < b => (0, 1)
    case _          => (0, 0)
  }

  def get_score(a: Seq[Int], b: Seq[Int]): (Int, Int) = {
    val (c, d) = a.zip(b).map { case (i, j) => comparison(i, j) }.unzip
    (c.sum, d.sum)
  }

  //  def main(args: Array[String]) {
  //    val sc = new java.util.Scanner(System.in)
  //    var a0 = sc.nextInt()
  //    var a1 = sc.nextInt()
  //    var a2 = sc.nextInt()
  //    var b0 = sc.nextInt()
  //    var b1 = sc.nextInt()
  //    var b2 = sc.nextInt()
  //
  //    val aliceScores = Seq(a0, a1, a2)
  //    val bobScores = Seq(b0, b1, b2)
  //
  //    val (aliceScore, bobScore) = get_score(aliceScores, bobScores)
  //
  //    println(s"$aliceScore $bobScore")
  //  }
}
