package EssentialScala

// Precise Square Dance!
//    Copy and paste calc from the previous exercise to create a calc2 that is generalized to work with Ints as well
//    as Doubles . If you have Java experience, this should be fairly straight forward.
//    If not, read the solution on below.
class Exercise2453 {

  println(calc2.square(2))
  println(calc2.square(2.0))

  println(calc2.cube(2.0))
  println(calc2.cube(2.0))

}

object calc2 {

  def square(v: Int): Int       = v * v
  def square(v: Double): Double = v * v

  def cube(v: Int): Int       = v * v
  def cube(v: Double): Double = v * v

}
