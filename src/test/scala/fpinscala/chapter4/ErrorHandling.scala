package fpinscala.chapter4

import fpinscala.chapter4.ChapterFour._
import org.scalatest._

class ErrorHandling extends FlatSpec with Matchers {

  "mean" should "give 10/4" in {
    assert(mean(Seq(4, 3, 2, 1)) === Just(2.5))
    assert(mean(Seq(4, 3, 2, 10)) === Just(4.75))
  }

  "variance" should "give var of seq" in {
    assert(variance(Seq(4, 3, 2, 10)) === Just(9.6875))
  }


}
