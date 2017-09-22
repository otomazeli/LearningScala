package ProjectEuler

/**
  * How many different ways can £2 be made using any number of coins?
  */
object Problem31 {

  def coinFinder(ms: List[Int], n: Int): Int = ms match {
    case h :: t =>
      if (h > n) 0
      else if (n == h) 1
      else coinFinder(ms, n - h) + coinFinder(t, n)
    case _ => 0
  }

}
