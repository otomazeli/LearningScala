package _99Problems

/**
  * Created by dan.dixey on 02/01/2017.
  */
object P20 {

  def removeAt[T](k: Int, list: List[T]): (List[T], T) =
    (list.take(k) ++ list.drop(k + 1), list(k))

}
