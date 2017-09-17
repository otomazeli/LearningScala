package ImpatientScala

/**
  * Control Structures and Functions - Chapter 2
  */
object Chapter2Main extends App {

  println("1. Write a function that computes the signum of a number")
  // signum actually exists in the standard library
  // therefore will be used to check the function I create

  def mySignum(n: Int): Int = n match {
    case k if k > 0 => 1
    case m if m < 0 => -1
    case _          => 0
  }

  println(mySignum(5), math.signum(5))
  println(mySignum(-5), math.signum(-5))
  println(mySignum(0), math.signum(0))
  println()

  println("2. What is the value of an empty block and what is its type?")
  println({}, {}.getClass.toString)
  println()

  println("4-5. Write a function equivalent to the Java Code block shown in book.")
  def countDown(n: Int): Unit = {
    for (i <- Range(n, 0, -1))
      println(i)
  }
  println(countDown(5))
  println()

  println("6. Write a for loop to calculate the product of all the Unicode codes")
  val s    = "Hello"
  var prod = 1.0
  for (i <- s) {
    prod = prod * i.toLong
  }
  println(prod.toLong)
  println()

  println("7. Write the same operation as above without a for loop")
  println(s.foldLeft(1L)(_ * _.toLong))
  println()

  println("8. Write a function of the method in the previous function.")
  def myProduct(s: String): Long = {
    s.foldLeft(1L)(_ * _.toLong)
  }
  println(myProduct("Dan"))
  println()

  println("9. Write a recursive version of the function above")
  def productRec(s: String): Long = s match {
    case k if k.length == 0 => 1
    case _                  => s(0) * productRec(s drop 1)
  }
  println(productRec("Dan"))
  println()

  println("10. Write function that computes the following (shown in script).")
  // recursive definition
  // xn = y2 if n is even and positive, where y = x ^ n / 2.
  // xn = x * x ^ n - 1 if n is odd and positive.
  // x0 = 1
  // xn = 1 / x ^ -n if n is negative.
  // Don't use a return statement.
  def nPower(x: BigInt, n: Int): BigInt = n match {
    case k if k > 0 && k % 2 == 0 => nPower(x, n / 2) * nPower(x, n / 2)
    case m if m > 0  => x * nPower(x, n - 1)
    case p if p == 0 => 1
    case _           => 1 / nPower(x, -n)
  }
  println(nPower(123, 9))

}
