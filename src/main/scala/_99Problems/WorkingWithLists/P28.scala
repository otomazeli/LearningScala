package _99Problems.WorkingWithLists

/**
  * Created by dan.dixey on 27/06/2017.
  */
object P28 {

  /**
    * Sorting a list of lists according to length of sublists.
    */
  def lsort[T](xa: List[List[T]]): List[List[T]] =
    xa.sortWith((l1, l2) => l1.length - l2.length < 0)

  /**
    * Again, we suppose that a list (InList) contains elements that are lists themselves.
    *     But this time the objective is to sort the elements of InList according to their length frequency;
    *     i.e. in the default, where sorting is done ascending order, lists with rare lengths
    *     are placed first, others with a more frequent length come later.
    */
  def lsortFreq[T](list: List[List[T]]): List[List[T]] =
    lsort(list)
      .groupBy(l => l.length).values.toList
      .sortWith((l1, l2) => l1.length - l2.length < 0)
      .flatten
}
