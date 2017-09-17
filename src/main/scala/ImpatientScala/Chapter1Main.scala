package ImpatientScala

// Imports

import scala.BigInt.probablePrime
import scala.math.{pow, sqrt}
import scala.util.Random

/**
  * The Basics - Chapter 1
  */
object Chapter1Main extends App {

  println("1: Methods applied to Int ( 3 )")
  Int.getClass.getMethods.foreach(x => println(x.getName))
  println()

  println("2. What is the sqrt of 3 when squared == 3?")
  val sqrt3   = sqrt(3)
  val sqrt3sq = pow(sqrt3, 2)
  println(sqrt3, sqrt3sq, sqrt3sq == 3)
  println()

  println("3. Are the res* variables val or var?")
  println("Not using the REPL but they are VAL")
  println()

  println("4. What happens when you multiple a number by a string")
  println("What will happen? " * 4)
  // Scala doc
  // http://www.scala-lang.org/api/current/#scala.collection.immutable.StringOps
  println()

  println("5. What does 10 max 2 do?")
  println(10 max 2)
  // Where is max in the scaladoc
  // http://www.scala-lang.org/api/current/#scala.Int
  println()

  println("6. Using BigInt calculate 2**1024")
  val value: BigInt = 2
  val output1       = value pow 1024
  // prints length of numbers
  println(output1.toString.length)
  println()

  println("7. What do you need to import to use probablePrime")
  println(probablePrime(100, Random))
  println()

  println("8. Convert a BigInt to base 36, identify the location relevent to this in Scaladoc.")
  println(output1.toString(36))
  // Scala doc
  // http://www.scala-lang.org/api/current/#scala.math.BigInt
  // def toString(radix: Int): String
  // Returns the String representation in the specified radix of this BigInt.
  println()

  println("9. How do you show the first and last character in a String")
  val someString: String = "someString"
  println(someString)
  println(someString.head, " or ", someString(0))
  println(someString.tail, " or ", someString(someString.length - 1))
  println()

  println("10. What do take, drop, takeRight and dropRight do?")
  println("Take:", someString.take(2))
  println("Drop:", someString.drop(2))
  println("Take Right:", someString.takeRight(2))
  println("Drop Right:", someString.dropRight(2))

}
