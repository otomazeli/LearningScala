package _99Problems

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P06 extends App {

  // Find out whether a list is a palindrome.
  val exampleList: Seq[Int] = List(1, 2, 3, 2, 1)
  val exampleList2: Seq[Int] = List(1, 2)

  def isPalindrome[A](x: TraversableOnce[A]): Boolean = x match {
    case start +: middle :+ end =>
      // Inspect what is happening within this pattern match
      println(start)
      println(middle)
      println(end)
      // Return this...
      start == end && isPalindrome(middle)
    case _ => true
  }

  println(isPalindrome(exampleList))
  println(isPalindrome(exampleList2))

}
