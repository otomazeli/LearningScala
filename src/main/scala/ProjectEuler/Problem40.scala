package ProjectEuler

import scala.collection.immutable

/**
  * If dn represents the nth digit of the fractional part, find the value of the following expression.
  */
object Problem40 {

  def champernownesConstant(m: Int): Int = {
    val stringDigits: immutable.IndexedSeq[Int] = (1 until 200000).flatMap(_.toString.map(_ - '0'))
    (0 until m).foldRight(1)((idx, b) => b * stringDigits(math.pow(10, idx).intValue - 1))
  }

}
