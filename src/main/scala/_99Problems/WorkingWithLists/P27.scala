package _99Problems.WorkingWithLists

/**
  * Group the elements of a set into disjoint subsets.
  *
  * PART A:
  *     In how many ways can a group of 9 people work in 3 disjoint subgroups
  *     of 2, 3 and 4 persons? Write a function that generates all the possibilities.
  *
  * PART B:
  *     Generalize the above predicate in a way that we can specify a list of group
  *     sizes and the predicate will return a list of groups.
  */
object P27 {

  def group3[T](list: List[T]): List[(List[T], List[T], List[T])] = {
    for {
      groupWith2Elements <- P26.combinations(2, list)
      groupWith3Elements <- P26.combinations(3, list diff groupWith2Elements)
    } yield
      (groupWith2Elements, groupWith3Elements, list diff groupWith2Elements diff groupWith3Elements)
  }

  def group[T](list: List[T], groupSizes: List[Int]): List[List[T]] =
    groupSizes match {
      case Nil => List(Nil)
      case n :: ns =>
        P26.combinations(n, list) flatMap (c => group(list diff c, ns))
    }

}
