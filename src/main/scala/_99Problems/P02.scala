package _99Problems

/**
  * Created by dan.dixey on 24/10/2016.
  */
object P02 {

  def penultimate[T](list: List[T]): T = list match {
    case x :: (_ :: Nil) => x
    case _ :: xs => penultimate(xs)
    case _ => throw new NoSuchElementException("list is empty")
  }

}
