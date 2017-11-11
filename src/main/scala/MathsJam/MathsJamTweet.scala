package MathsJam

object MathsJamTweet {
  // Original Tweet: https://twitter.com/tombutton/status/929358013990866945

  def isPrime(n: Int): Boolean = !Range(2, n - 1).exists(n % _ == 0)

  def simpleCheck(k: Int): Boolean = {
    isPrime(k) & isPrime((k + 2) / 3) & isPrime((k + 1) / 2)
  }

  def simpleCheck2(k: Int): Boolean = {
    isPrime(k) & isPrime((k + 2) / 3) & isPrime((k + 1) / 2) & isPrime((k + 3) / 4)
  }

  def main(args: Array[String]): Unit = {
    // Specify a range to check
    val rangeValues = Stream.range[Int](2018, 12722)

    // Display the result
    println(s"Next value            => ${rangeValues.filter(simpleCheck).toList.head}")
    // Next value            : 2557
    println(s"Next value (extended) => ${rangeValues.filter(simpleCheck2).toList.head}")
    // Next value (extended) : 12721
  }

}
