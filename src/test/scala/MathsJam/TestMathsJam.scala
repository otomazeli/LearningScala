package MathsJam

import MathsJam.MathsJamTweet.{simpleCheck, simpleCheck2}
import org.scalatest.{FlatSpec, Matchers}

class TestMathsJam extends FlatSpec with Matchers {

  "MathsJam question" should "prime finder" in {
    val rangeValues = Stream.range[Int](2018, 12722)
    assert(rangeValues.filter(simpleCheck).toList.head == 2557)
    assert(rangeValues.filter(simpleCheck2).toList.head == 12721)
  }
}
