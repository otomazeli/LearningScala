package _99Problems

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P06 {

  def isPalindrome[A](x: Traversable[A]): Boolean = x match {
    case start +: middle :+ end =>
      // Inspect what is happening within this pattern match
          // println(start)
          // println(middle)
          // println(end)
      // Return this...
      start == end && isPalindrome(middle)
    case _ => true
  }

}
