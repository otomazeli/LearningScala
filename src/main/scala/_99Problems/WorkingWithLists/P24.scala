package _99Problems.WorkingWithLists

/**
  * Lotto: Draw N different random numbers from the set 1..M.
  */
object P24 {

  private[this] val randomGenerator = scala.util.Random

  def lotto(n: Int, choice: Int): List[Int] = {
    val rangeValues = (0 to choice).toList
    @scala.annotation.tailrec
    def selection(n: Int, values: List[Int], acc: List[Int] = Nil): List[Int] =
      acc.size match {
        case m if m == n => acc
        case _ =>
          val indexer = randomGenerator.nextInt(values.size)
          selection(n, dropIndex(values, indexer), values(indexer) :: acc)
      }
    selection(n, rangeValues, Nil)
  }

  private[this] def dropIndex[T](list: List[T], idx: Int): List[T] =
    list.zipWithIndex.filter(_._2 != idx).map(_._1)

}
