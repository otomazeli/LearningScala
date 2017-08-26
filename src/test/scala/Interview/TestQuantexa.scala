package Interview

import Interview.QuantexaTestQuestion.get_max_difference
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dan.dixey on 06/07/2017.
  */
class TestQuantexa  extends FlatSpec with Matchers {

  "question one" should "find the max" in {
    assert(get_max_difference(List(1, 2, 3, 5, 12, 50, 0, 39)) === 49)
    assert(get_max_difference(List()) === Int.MinValue)
  }
}


