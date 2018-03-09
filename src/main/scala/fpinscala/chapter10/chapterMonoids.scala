package fpinscala.chapter10

trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

// Examples from the Book
object myMonoids {

  val stringMonoid: Monoid[String] = new Monoid[String] {
    override def op(a1: String, a2: String) = a1.toString + a2.toString
    override val zero                       = ""
  }

  def listMonoid[A] = new Monoid[List[A]] {
    override def op(a1: List[A], a2: List[A]): List[A] = a1 ++ a2
    override val zero                                  = Nil
  }

  /**
    * Exercise 01
    * Give Monoid instances for integer addition and multiplication as well as
    * the Boolean operators.
    */
  val intAddition: Monoid[Int] = new Monoid[Int] {
    override def op(a1: Int, a2: Int): Int = a1 + a2
    override def zero: Int                 = 0
  }

  def intMultiplication: Monoid[Int] = new Monoid[Int] {
    override def op(a1: Int, a2: Int): Int = a1 * a2
    override def zero: Int                 = 1
  }

  def booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
    override def op(a1: Boolean, a2: Boolean): Boolean = a1 || a2
    override def zero: Boolean                         = false
  }

  def booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
    override def op(a1: Boolean, a2: Boolean): Boolean = a1 && a2
    override def zero: Boolean                         = true
  }

  /**
    * Exercise 02
    * Give a Monoid instance for combining Option values.
    */
  def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Option[A]] {
    override def op(a1: Option[A], a2: Option[A]): Option[A] = a1.orElse(a2)
    override def zero: Option[A]                             = None
  }

  def dual[A](m: Monoid[A]): Monoid[A] = new Monoid[A] {
    def op(x: A, y: A): A = m.op(y, x)
    val zero: A           = m.zero
  }

  /**
    * Exercise 03
    * A function having the same argument and return type is sometimes called an
    * endofunction. Write a monoid for endofunctions.
    */
  def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
    override def op(a1: A => A, a2: A => A): A => A = a1 compose a2
    override def zero: A => A                       = identity
  }

  def concatenate[A](as: List[A], m: Monoid[A]): A = {
    as.foldLeft(m.zero)(m.op)
  }

  /**
    * Exercise 05
    * Write this function.
    */
  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))
  }

  /**
    * Exercise 06 (hard)
    * The foldMap function can be implemented using either foldLeft or foldRight.
    * But you can also write foldLeft and foldRight using foldMap! Try it.
    */
  def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B = {
    foldMap(as, endoMonoid[B])(f.curried)(z)
  }

  /**
    * Exercise 07
    * Implement a foldMap for IndexedSeq. Your implementation should use the
    * strategy of splitting the sequence in two, recursively processing each
    * half, and then adding the answers together with the monoid.
    */
  def foldMapV[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B =
    if (v.isEmpty) m.zero
    else if (v.length == 1) f(v(0))
    else {
      val s = v.splitAt(v.length / 2)
      m.op(foldMapV(s._1, m)(f), foldMapV(s._2, m)(f))
    }

  def foldMapV_org[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B = {
    if (v.length >= 4) {
      val s = v.splitAt(v.length / 2)
      m.op(foldMapV(s._1, m)(f), foldMapV(s._2, m)(f))
    } else {
      v.foldLeft(m.zero)((b, a) => m.op(b, f(a)))
    }
  }

  /**
    * Exercise 09 (hard)
    * Use foldMap to detect whether a given IndexedSeq[Int] is ordered. You’ll
    * need to come up with a creative Monoid.
    */
  def ordered(ints: IndexedSeq[Int]): Boolean = {
    // Reference: (Int, Int, Boolean) = (Min, Max, IsOrdered)
    val mon = new Monoid[Option[(Int, Int, Boolean)]] {
      def op(o1: Option[(Int, Int, Boolean)],
             o2: Option[(Int, Int, Boolean)]): Option[(Int, Int, Boolean)] =
        (o1, o2) match {
          case (Some((x1, y1, p)), Some((x2, y2, q))) =>
            Some((x1 min x2, y1 max y2, p && q && y1 <= x2))
          case (x, None) => x
          case (None, x) => x
        }
      val zero = None
    }
    foldMapV(ints, mon)(i => Some((i, i, true))).forall(_._3)
  }

  sealed trait WordCount

  case class Stub(chars: String)                                   extends WordCount
  case class Part(leftStub: String, words: Int, rightStub: String) extends WordCount

  object NonEmptySpaceString {
    def unapply(s: String) = if (s.forall(_.isSpaceChar) && s.length > 0) Some(s) else None
  }

  var wordCountMonoid = new Monoid[WordCount] {
    override def op(a1: WordCount, a2: WordCount): WordCount = (a1, a2) match {
      case (Stub(leftStub), Stub(rightStub)) =>
        Stub(leftStub + rightStub)

      case (Stub(leftStub), Part("", wordCount, rightStub)) =>
        Part(leftStub, wordCount, rightStub)

      case (Part(leftStub, wordCount, ""), Stub(rightStub)) =>
        Part(leftStub, wordCount, rightStub)

      case (Stub(NonEmptySpaceString(_)), Part(_, wordCount, rightStub)) =>
        Part("", wordCount + 1, rightStub)

      case (Part(leftStub, wordCount, _), Stub(NonEmptySpaceString(_))) =>
        Part(leftStub, wordCount + 1, "")

      case (Stub(leftLeftStub), Part(leftRightStub, wordCount, rightStub)) =>
        Part(leftLeftStub + leftRightStub, wordCount, rightStub)

      case (Part(leftStub, wordCount, rightLeftStub), Stub(rightRightStub)) =>
        Part(leftStub, wordCount, rightLeftStub + rightRightStub)

      case (Part(leftStub, leftWordCount, centreLeftStub),
            Part(centreRightStub, rightWordCount, rightStub)) =>
        Part(
          leftStub,
          leftWordCount + rightWordCount + (if ((centreLeftStub + centreRightStub) == "") 0 else 1),
          rightStub
        )
    }

    override def zero: WordCount = Stub("")
  }

  trait Foldable[F[_]] {
    def foldRight[A, B](as: F[A])(z: B)(f: (A, B) => B): B
    def foldLeft[A, B](as: F[A])(z: B)(f: (B, A) => B): B
    def foldMap[A, B](as: F[A])(f: A => B)(mb: Monoid[B]): B
    def concatenate[A](as: F[A])(m: Monoid[A]): A =
      foldLeft(as)(m.zero)(m.op)
  }

  /** Exercise 12
    *
    * Implement Foldable[List], Foldable[IndexedSeq], and Foldable[Stream].
    *
    * Remember that they can be implemented in terms of one another, but that that may not be the most efficient
    * implementation.
    */
  val listFoldable: Foldable[List] = new Foldable[List] {
    override def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)

    override def foldMap[A, B](as: List[A])(f: (A) => B)(mb: Monoid[B]): B =
      foldRight(as)(mb.zero) { (a, b) =>
        mb.op(b, f(a))
      }
  }

  val indexedSeqFoldable: Foldable[IndexedSeq] = new Foldable[IndexedSeq] {
    override def foldRight[A, B](as: IndexedSeq[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: IndexedSeq[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)

    override def foldMap[A, B](as: IndexedSeq[A])(f: (A) => B)(mb: Monoid[B]): B =
      foldLeft(as)(mb.zero) { (b, a) =>
        mb.op(b, f(a))
      }
  }

  val streamFoldable: Foldable[Stream] = new Foldable[Stream] {
    override def foldRight[A, B](as: Stream[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: Stream[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)

    override def foldMap[A, B](as: Stream[A])(f: (A) => B)(mb: Monoid[B]): B =
      foldLeft(as)(mb.zero) { (b, a) =>
        mb.op(b, f(a))
      }
  }

  /**
    * Exercise 16
    * Prove it. Notice that your implementation of op is obviously associative
    * so long as A.op and B.op are both associative.
    */
  def productMonoid[A, B](A: Monoid[A], B: Monoid[B]): Monoid[(A, B)] = new Monoid[(A, B)] {
    def op(a1: (A, B), a2: (A, B)): (A, B) = (A.op(a1._1, a2._1), B.op(a1._2, a1._2))
    def zero: (A, B)                       = (A.zero, B.zero)
  }

  def mapMergeMonoid[K, V](V: Monoid[V]): Monoid[Map[K, V]] = new Monoid[Map[K, V]] {
    def zero = Map()
    def op(a: Map[K, V], b: Map[K, V]) = a.foldLeft(b) {
      case (m, (k, v)) => m + (k -> V.op(v, m.getOrElse(k, V.zero)))
    }
  }

  val M: Monoid[Map[String, Map[String, Int]]] = {
    mapMergeMonoid[String, Map[String, Int]](mapMergeMonoid[String, Int](intMultiplication))
  }

  /**
    * Exercise 17
    * Write a monoid instance for functions whose results are monoids.
    */
  def functionMonoid[A, B](B: Monoid[B]): Monoid[A => B] = new Monoid[A => B] {
    def op(a1: A => B, a2: A => B): A => B = a => B.op(a1(a), a2(a))
    def zero: A => B                       = a => B.zero
  }

  /**
    * Exercise 18
    * A bag is like a set, except that it’s represented by a map that contains
    * one entry per element with that element as the key, and the value under
    * that key is the number of times the element appears in the bag.
    */
  def bag[A](as: IndexedSeq[A]): Map[A, Int] =
    foldMapV(as, mapMergeMonoid[A, Int](intAddition))((a: A) => Map(a -> 1))

  /**
    *  Running Examples
    */
  //  def main(args: Array[String]): Unit = {
  //
  //    // stringMonoid
  //    println("foldRight", List("D", "A", "N").foldRight(stringMonoid.zero)(stringMonoid.op))
  //    println("foldLeft", List("D", "A", "N").foldLeft(stringMonoid.zero)(stringMonoid.op))
  //
  //    // intMultiplication
  //    println("foldRight", List(2, 3, 4).foldRight(intMultiplication.zero)(intMultiplication.op))
  //    println("foldLeft", List(2, 3, 4).foldLeft(intMultiplication.zero)(intMultiplication.op))
  //
  //    // foldMap
  //    println(foldMap(List(2, 3, 4), stringMonoid)(_.toString))
  //
  //    // ordered
  //    println("ordered", ordered(IndexedSeq(1, 3, 2, 4)))
  //
  //    // M - O, WOW!!
  //    println(
  //      M.op(Map(("A", Map(("A", 4))), ("D", Map(("D", 10)))),
  //           Map(("A", Map(("A", 3))), ("C", Map(("C", 2)))))
  //    )
  //
  //    // listFoldable
  //    println(listFoldable.foldRight(List(1, 2, 3, 4))("") {
  //      case (a, b) => a.toString + b.toString
  //    })
  //
  //    // listFoldable 2
  //    println(listFoldable.foldMap(List(1, 2, 3, 4))(_.toString)(stringMonoid))
  //
  //    // bag
  //    println(bag(
  //      ("This is the BETA release for Linux Mint 18.3 “Sylvia” MATE Edition. Linux Mint 18.3 Sylvia " +
  //        "MATE Edition Linux Mint 18.3 is a long term support release which will be supported until 2021.")
  //        .split(" ")).get("BETA"))
  //  }
}
