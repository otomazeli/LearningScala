package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P08 extends App {

  // Eliminate consecutive duplicates of list elements.
  val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  val expectedResult = List('a, 'b, 'c, 'a, 'd, 'e)

  println("Input: " + input)

  def compress[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => h :: compress(tail.dropWhile(_ == h))
  }

  println("Output function: " + compress(input))
  println("Check: " + (compress(input) == expectedResult))
}
