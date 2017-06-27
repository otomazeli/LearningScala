package _99Problems.WorkingWithLists

import scala.util.Random

/**
  * P25 Generate a random permutation of the elements of a list.
  */
object P25 {

  def randomPerm[T](list: List[T]): List[T] = {
    val all = list.permutations.toList
    all(Random.nextInt(all.length))
  }

}
