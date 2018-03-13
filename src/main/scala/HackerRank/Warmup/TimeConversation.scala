package HackerRank.Warmup

object TimeConversation {

  def timeConversion(s: String): String = {
    val timeArray: Array[String] = s.substring(0, 8).split(":")

    if (s.substring(8).toUpperCase == "AM") {
      if (timeArray(0).toInt == 12) {
        s"00:${timeArray(1)}:${timeArray(2)}"
      } else {
        s.substring(0, 8)
      }

    } else {
      if (timeArray(0).toInt == 12) {
        s.substring(0, 8)
      } else {
        s"${timeArray(0).toInt + 12}:${timeArray(1)}:${timeArray(2)}"
      }
    }
  }

  //  def main(args: Array[String]) {
  //    val sc     = new java.util.Scanner(System.in)
  //    var s      = sc.next()
  //    val result = timeConversion(s)
  //    println(result)
  //  }
}
