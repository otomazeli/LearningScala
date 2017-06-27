package _99Problems.WorkingWithLists

/**
  * Insert an element at a given position into a list.
  */
object P21 {

  def insertAt[T](t: T, pos: Int, list: List[T]): List[T] = {
    @scala.annotation.tailrec
    def insertAt(remaining: List[T], first: List[T], cur: Int): List[T] =
      remaining match {
        case _ if cur == pos => (first :+ t) ++ remaining
        case x :: xs         => insertAt(xs, first :+ x, cur + 1)
        case _               => Nil
      }
    insertAt(list, Nil, 0)
  }

}
