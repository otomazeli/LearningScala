package fpinscala.chapter2

// A Comment
/* Another style of comments */
/**
  * Documentation Comment
  */
object myModule {

  // monomorphic functions
  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  // Equivalent to the 'void' in Java
  //def main(args: Array[String]): Unit = {
  //  println(formatAbs(-42))
  //}

  // Factorial function
  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }

  // Exercise 2.1 - Fibonacci nth value finder
  def fib(n: Int): Int = {
    @annotation.tailrec
    def myGo(n: Int, x: Int, b: Int): Int = {
      if (n <= 0) x
      else myGo(n - 1, x + b, x)
    }

    myGo(n, 1, 0)
  }

  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d."
    msg.format(n, factorial(n))
  }

  // Higher order function
  def formatResult(name: String, n: Int, f: Int => Int): String = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("Absolute", -42, abs))
    println(formatResult("Absolute", 7, factorial))

    /*
     * Calling HOFs with anonymous functions
     */
    val strArray = Array("Dan", "Dixey", "Scala")
    println(strArray(findFirst(strArray, (s: String) => s.equals("Scala"))))

    /* Alternative */
    val intArray = Array(1, 3, 4, 5, 100)
    println(intArray(findFirst(intArray, 100.equals)))

  }

  // Monomorphic function to find a String in an array
  def monoFindFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)

    loop(0)
  }

  // Polymorphic function to find an element in an array
  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)

    loop(0)
  }
  // This is an example of a polymorphic function, sometimes called a generic function.

  // Exercise 2.2 : Implement a polymorphic function to check whether an `Array[A]` is sorted
  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (gt(as(n), as(n + 1))) false
      else loop(n + 1)
    }

    loop(0)
  }

  // Count elements in Array using a polymorphic function - unguided
  def myArrayCounter[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loopOo(n: Int, count: Int): Int = {
      if (n == as.length - 1 & p(as(n))) count + 1
      else if (n == as.length - 1) count
      else if (p(as(n))) loopOo(n + 1, count + 1)
      else loopOo(n + 1, count)
    }

    loopOo(0, 0)
  }

  // Following types to implementations
  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = (b: B) => f(a, b)
  // And we’re done! The result is a higher-order function that takes
  // a function of two arguments and partially applies it.

  // Exercise 2.3 - currying
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)

  // Exercise 2.4 - un-currying
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

  // Exercise 2.5 - composing
  def composeBook[A, B, C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))

}
