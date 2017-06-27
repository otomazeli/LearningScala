package _99Problems.WorkingWithLists

/**
  * Remove the Kth element from a list.
  */
object P20 {

  def removeAt[T](k: Int, list: List[T]): (List[T], T) =
    (list.take(k) ++ list.drop(k + 1), list(k))

}
