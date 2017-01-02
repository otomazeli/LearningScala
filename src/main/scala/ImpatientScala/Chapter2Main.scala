package ImpatientScala

/**
  * Created by dan.dixey on 23/10/2016.
  */
object Chapter2Main extends App {

  println("1. Write a function that computes the signum of a number")
  // signum actually exists in the standard library
  // therefore will be used to check the function I create

  def my_signum(n: Int): Int = {
    if (n > 0) 1
    else if (n < 0) -1
    else 0
  }

  println(my_signum(5), math.signum(5))
  println(my_signum(-5), math.signum(-5))
  println(my_signum(0), math.signum(0))
  println()

  println("2. What is the value of an empty block and what is its type?")
  println({}, {}.getClass.toString)
  println()

  println("4-5. Write a function equivilent to the Java Code block shown in book.")
  def countDown(n: Int) = {
    for( i <- Range(n, 0, -1) )
      println(i)
  }
  println(countDown(5))
  println()

  println("6. Write a for loop to calculate the product of all the Unicode codes")
  val s = "Hello"
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
  def my_product(s: String): Long = {
    s.foldLeft(1L)(_ * _.toLong)
  }
  println(my_product("Dan"))
  println()

  println("9. Write a recursive version of the function above")
  def productRec(s: String):Long = {
    if(s.length == 0) 1
    else s(0) * productRec(s drop 1)
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
  def n_power(x: BigInt, n: Int): BigInt = {
    if(n > 0 && n % 2 == 0) n_power(x, n / 2) * n_power(x, n / 2)
    else if(n > 0) x * n_power(x, n - 1)
    else if(n == 0) 1
    else 1 / n_power(x, -n)
  }
  println(n_power(123, 9))
  println()

}
