package _99Problems.WorkingWithLists

/**
  * Extract a given number of randomly selected elements from a list.
  */
object P23 {

  private[this] val randomGenerator = scala.util.Random

  @scala.annotation.tailrec
  def randomSelect[A](n: Int, xa: List[A], acc: List[A] = Nil): List[A] =
    acc.size match {
      case m if m == n => acc
      case _ =>
        randomSelect(n, xa, xa(randomGenerator.nextInt(xa.size)) :: acc)
    }

}
