package EssentialScala

// Square Dance!
//  Define an object called calc with a method square that accepts a Double as an argument and... you guessed it...
//  squares its input. Add a method called cube that cubes its input calling square as part of its result calculate on.
object Exercise2452 {

  println(calc.square(4))

}

object calc {

  def square(value: Double): Double =
    value * value

  def cube(value: Double): Double =
    value * square(value)
}
