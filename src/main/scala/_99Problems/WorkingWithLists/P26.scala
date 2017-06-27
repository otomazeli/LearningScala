package _99Problems.WorkingWithLists

/**
  * Generate the combinations of K distinct objects chosen from the N elements of a list.
  *
  * In how many ways can a committee of 3 be chosen from a group of 12 people? We all know
  * that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial
  * coefficient). For pure mathematicians, this result may be great. But we want to really
  * generate all the possibilities.
  *
  */
object P26 {

  def combinations[T](k: Int, l: List[T]): List[List[T]] =
    l.combinations(k).toList
}
