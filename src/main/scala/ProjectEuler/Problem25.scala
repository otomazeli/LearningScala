package ProjectEuler

/**
  * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
  */
object Problem25 {

  def findingLength(l: Int): Int = {
    lazy val fibs: Stream[BigInt] = 0 #:: fibs.scanLeft(BigInt(1))(_ + _)
    fibs.view.takeWhile(_.toString.length < l).length
  }

}
