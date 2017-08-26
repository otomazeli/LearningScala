package Interview

/**
  * Created by dan.dixey on 22/06/2017.
  */
object QuantexaTestQuestion {

  // Generate an infinite fibonacci sequence
  lazy val fibs: Stream[Int] = 0 #:: 1 #::
    fibs.zip(fibs.tail).map { n =>
      n._1 + n._2
    }

  def get_max_difference(xs: List[Int]): Int = {
    @scala.annotation.tailrec
    def go(xa: List[Int], v: Int): Int = {
      xa match {
        case Nil => v
        case _ :: Nil => v
        case _ =>
          val newDiff = xa.tail.max - xa.head
          go(xa.tail, if (newDiff > v) newDiff else v)
      }
    }

    xs.size match {
      case x if x >= 2 => go(xs, xs(1) - xs.head)
      case _ => Int.MinValue
    }
  }
}
