package _99Problems.WorkingWithLists

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P02 {
  @scala.annotation.tailrec
  def penultimate[T](list: List[T]): T = list match {
    case x :: (_ :: Nil) => x
    case _ :: xs         => penultimate(xs)
    case _               => throw new NoSuchElementException("list is empty")
  }

}
