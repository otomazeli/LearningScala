package fpinscala.chapter1.original

import org.scalatest.{FlatSpec, Matchers}


class CafeTest extends FlatSpec with Matchers {

  "CafeTest.buyCoffee" should "purchase a coffee correctly" in {
    val (coffee, charge) = new Cafe().buyCoffee(new CreditCard)
    assert(coffee != null)
    assert(charge != null)
    assert(charge.amount == new Coffee().price)
  }

  "CafeTest.buyCoffees" should "calculate a sum of all the coffees" in  {
    val numOfCoffees = 1000
    val myCard = new CreditCard
    val (coffees, charge) = new Cafe().buyCoffees(myCard, numOfCoffees)
    assert(coffees != null)
    assert(charge != null)
    assert(charge.amount == new Coffee().price * numOfCoffees)
  }

}
