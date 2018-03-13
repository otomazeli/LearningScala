package EssentialScala

sealed trait DivisionResult

final case class Finite(value: Int) extends DivisionResult
case object Infinite                extends DivisionResult

object divide {
  def apply(num: Int, den: Int): DivisionResult =
    if (den == 0) Infinite
    else Finite(num / den)
}
