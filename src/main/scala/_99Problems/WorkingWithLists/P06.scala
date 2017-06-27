package _99Problems.WorkingWithLists

/**
  * Find out whether a list is a palindrome.
  */
object P06 {
  @scala.annotation.tailrec
  def isPalindrome[A](x: Traversable[A]): Boolean = x match {
    case start +: middle :+ end =>
      start == end && isPalindrome(middle)
    case _ => true
  }

}
