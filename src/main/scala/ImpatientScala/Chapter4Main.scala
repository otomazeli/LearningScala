package ImpatientScala

import java.io.InputStream

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.{immutable, mutable}

/**
  * - Maps and Tuples - Chapter 4
  */
object Chapter4Main {

  println(
    "1. Set up a map of prices for a number of gizmos that you covet. Then produce a second map with the " +
      "same keys and the prices at a 10 percent discount."
  )
  val myGizmos: Map[String, Int] =
    Map("Laptop" -> 300, "MacBook" -> 200, "Amazon Prime" -> 35)
  val discounted: Map[String, Double] = myGizmos.map { case (x, y) => (x, y * 0.9) }
  println(discounted)
  assert(discounted == Map("Laptop" -> 270.0, "MacBook" -> 180.0, "Amazon Prime" -> 31.5))
  println()

  println(
    "2. Write a program that reads words from a file. Use a mutable map to count how often each word appears. " +
      "To read the words, simply use a java.util.Scanner:  " +
      "val in = new java.util.Scanner(new java.io.File('myfile.txt')) while (in.hasNext()) process in.next() " +
      " Or look at Chapter 9 for a Scalaesque way. At the end, print out all words and their counts."
  )
  val myStream: InputStream =
    getClass.getResourceAsStream("/scala_introduction.txt")
  val dataTxt: Array[String] =
    scala.io.Source.fromInputStream(myStream).mkString.split("\\s+")
  val uw: mutable.Map[String, Int] =
    new scala.collection.mutable.HashMap[String, Int]
  dataTxt.foreach(w => uw(w) = uw.getOrElse(w, 0) + 1)
  println(uw.toSeq.sortWith(_._2 > _._2).take(20))
  println()

  println(
    "3. Repeat the preceding exercise with an immutable map."
  )
  val wordCounts: Map[String, Int] =
    (for (w <- dataTxt.distinct)
      yield (w, dataTxt.count(_ == w))).toMap
  println(wordCounts.toSeq.take(20))
  println()

  println(
    "4. Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order."
  )
  println(wordCounts.toSeq.sortWith(_._2 > _._2).take(20))
  println()

  println(
    "6. Define a linked hash map that maps \"Monday\" to java.util.Calendar.MONDAY , and similarly for the " +
      "other weekdays. Demonstrate that the elements are visited in insertion order."
  )
  val days = scala.collection.mutable.LinkedHashMap(
    "MONDAY"    -> java.util.Calendar.MONDAY,
    "TUESDAY"   -> java.util.Calendar.TUESDAY,
    "WEDNESDAY" -> java.util.Calendar.WEDNESDAY,
    "THURSDAY"  -> java.util.Calendar.THURSDAY,
    "FRIDAY"    -> java.util.Calendar.FRIDAY,
    "SATURDAY"  -> java.util.Calendar.SATURDAY,
    "SUNDAY"    -> java.util.Calendar.SUNDAY
  )
  println(days.take(3))
  assert(days == (for (d <- days) yield d))
  println()

  println(
    "7.  Print a table of all Java properties. You need to find the length of the longest key before you " +
      "can print the table."
  )
  val props: scala.collection.Map[String, String] = System.getProperties
  val maxLength: Int                              = props.keys.maxBy(_.length).length
  for ((k, v) <- props) println(k + " " * (maxLength - k.length) + "|" + v)
  println()

  println(
    "8. Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and largest " +
      "values in the array."
  )
  def minMax(a: Array[Int]): (Int, Int) = (a.min, a.max)
  val a8: Array[Int]                    = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(a8.mkString("< ", ",", " >"), minMax(a8))
  assert(minMax(a8) == (1, 10))
  println()

  println(
    "9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values less " +
      "than v , equal to v , and greater than v ."
  )
  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) =
    (values.count(_ < v), values.count(_ == v), values.count(_ > v))
  println(a8.mkString("< ", ",", " >"), lteqgt(a8, 3))
  assert(lteqgt(a8, 3) == (2, 1, 7))
  println()

  println(
    "10. What happens when you zip together two strings, such as 'Hello'.zip('World') ? Come up with a " +
      "plausible use case."
  )
  val in10: immutable.IndexedSeq[(Char, Char)] = "Hello".zip("World")
  println(s"It returns a Sequence of Tuple with characters from same position in each string: ${in10
    .take(2)}")
  println(s"Example Use: Find difference between two strings: ${in10.count(l => l._1 != l._2)}")

}
