package Miscellaneous

case class Bag[A](content: A) {
  def map[B](f: A => B): Bag[B]          = Bag(f(content))
  def flatMap[B](f: A => Bag[B]): Bag[B] = f(content)
  def flatten: A                         = content
}

case class Sugar(weight: Double)

object PeanutShop extends App {
  // the guy who is expert at making sugar half
  def half = (sugar: Sugar) => Sugar(sugar.weight / 2)

  val sugarBag: Bag[Sugar] = Bag(Sugar(1)) // Bag functor of type sugar

  // map is the guy in our story who can perform operations
  // by unwrapping the bag and then calling respective function
  // and wraps the content back in a bag
  val halfSugarBag: Bag[Sugar] = sugarBag.map(sugar => half(sugar))
  println(sugarBag, halfSugarBag)

  val sugarBag2: Bag[Sugar] = Bag(Sugar(1))
  println(sugarBag2.map(identity) == sugarBag2)

  def double = (sugar: Sugar) => Bag(Sugar(sugar.weight * 2))

  val doubleSugarBag: Bag[Sugar]  = sugarBag.flatMap(sugar => double(sugar))
  val doubleSugarBag2: Bag[Sugar] = sugarBag.map(sugar => double(sugar)).flatten

  println(doubleSugarBag, doubleSugarBag2)

  val sugarBag3: Bag[Sugar] = Bag(Sugar(1))
  println(sugarBag3.flatMap(sugar => double(sugar)))

  val sugarBag4: Sugar = Bag(Sugar(1)).flatten

  val sugarBag5: List[Bag[Sugar]] = List(Bag(Sugar(1)), Bag(Sugar(2)))
  println(sugarBag5.map(x => x.flatMap(s => double(s))))

}
