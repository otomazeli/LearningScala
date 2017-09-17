package ProjectEuler

/**
  * The four adjacent digits in the 1000-digit number that have the greatest
  * product are 9 × 9 × 8 × 9 = 5832.
  *
  * String below
  *
  * Find the thirteen adjacent digits in the 1000-digit number that have the
  * greatest product. What is the value of this product?
  *
  */
object Problem8 {

  def adjacentProduct(s: String, slideSize: Int): Int = {
    s.filter(_.isDigit).map(_.asDigit).sliding(slideSize).map(_.product).max
  }

}
