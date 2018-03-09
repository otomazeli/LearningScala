package fpinscala.chapter11

trait FunctorD[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]

  def distribute[A, B](fab: F[(A, B)]): (F[A], F[B]) =
    (map(fab)(_._1), map(fab)(_._2))

  def codistribute[A, B](e: Either[F[A], F[B]]): F[Either[A, B]] =
    e match {
      case Left(fa)  => map(fa)(Left(_))
      case Right(fb) => map(fb)(Right(_))
    }
}

trait Monad[F[_]] extends FunctorD[F] {
  def unit[A](a: => A): F[A]
  def flatMap[A, B](ma: F[A])(f: A => F[B]): F[B]
  def map2[A, B, C](ma: F[A], mb: F[B])(f: (A, B) => C): F[C] =
    flatMap(ma)(a => map(mb)(b => f(a, b)))
}

object chapterMonadsFunctors {

  // Example implementation for Option
  implicit val functorForOption: FunctorD[Option] = new FunctorD[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa match {
      case None    => None
      case Some(a) => Some(f(a))
    }
  }

  val listFunctor: FunctorD[List] = new FunctorD[List] {
    def map[A, B](as: List[A])(f: A => B): List[B] = as map f
  }

  /** Exercise 1
    *
    * Write monad instances for Par, Parser, Option, Stream, and List.
    */
  import fpinscala.chapter7.Chapter7.Par.Par

  val parMonad: Monad[Par] = new Monad[Par] {
    override def unit[A](a: => A): Par[A] =
      fpinscala.chapter7.Chapter7.Par.unit(a)
    override def flatMap[A, B](ma: Par[A])(f: (A) => Par[B]): Par[B] =
      fpinscala.chapter7.Chapter7.Par.flatMap(ma)(f)
    override def map[A, B](fa: Par[A])(f: A => B) = ???
  }

  val optionMonad: Monad[Option] = new Monad[Option] {
    override def unit[A](a: => A): Option[A]                                  = Some(a)
    override def flatMap[A, B](ma: Option[A])(f: (A) => Option[B]): Option[B] = ma.flatMap(f)
    override def map[A, B](fa: Option[A])(f: A => B)                          = ???
  }

  val listMonad: Monad[List] = new Monad[List] {
    override def unit[A](a: => A): List[A]                              = List(a)
    override def flatMap[A, B](ma: List[A])(f: (A) => List[B]): List[B] = ma.flatMap(f)
    override def map[A, B](fa: List[A])(f: A => B)                      = ???
  }

  //  def main(args: Array[String]): Unit = {
  //    // List functor
  //    println(listFunctor.map(List(1, 3, 3, 4))(a => a * 3 + 1))
  //  }

}
