package _99Problems.WorkingWithLists

/**
  * Eliminate consecutive duplicates of list elements.
  */
object P08 {

  def compress[A](ls: List[A]): List[A] = ls match {
    case Nil       => Nil
    case h :: tail => h :: compress(tail.dropWhile(_ == h))
  }

}
