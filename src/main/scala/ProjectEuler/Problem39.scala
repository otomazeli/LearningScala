package ProjectEuler

/**
  * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are
  * exactly three solutions for p = 120.
  *
  * {20,48,52}, {24,45,51}, {30,40,50}
  *
  * For which value of p ≤ 1000, is the number of solutions maximised?
  *
  */
object Problem39 {

  def integerRightTriangles(prim: Int): Int = {
    prim + 1000 * (for {
      a <- List.range(1, prim / 2)
      b <- List.range(1, (prim - a) / 2 + 1)
      c <- List(prim - a - b)
      if a * a + b * b == c * c
    } yield 1).length
  }

}
