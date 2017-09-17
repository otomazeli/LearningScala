package fpinscala.chapter1.original

class Cafe {

  def buyCoffees(creditCard: CreditCard, numOfCoffees: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] =
      List.fill(numOfCoffees)(buyCoffee(creditCard))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }

  def buyCoffee(creditCard: CreditCard): (Coffee, Charge) = {
    val coffee: Coffee = new Coffee()
    (coffee, Charge(creditCard, coffee.price))
  }

}
