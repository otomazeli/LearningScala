package dbiz.chapter1.extended

import dbiz.chapter1.original.CreditCard

/**
  * Created by dan.dixey on 23/04/2017.
  */
class CafeV2 {

  val cortado = new Coffee("Cortado", 1.75)
  val expresso = new Coffee("Expresso", 1.95)
  val ladyGrey = new Tea("Lady Grey", 2.15)
  val cola = new Fizzy("Cola", 2.55)

  def buyDrinks(creditCard: CreditCard,
                drinksBought: List[String]): (List[Drink], Charge) = {

    val purchases: List[(Drink, Charge)] =
      drinksBought.map(drinkName => buyDrink(creditCard, drinkName))

    val (drinks, charges) = purchases.unzip
    (drinks, charges.reduce((c1, c2) => c1.combine(c2)))
  }

  def buyDrink(creditCard: CreditCard, name: String): (Drink, Charge) = {
    val drink: Drink = name match {
      case x if x == "Cortado" => cortado
      case x if x == "Expresso" => expresso
      case x if x == "Lady Grey" => ladyGrey
      case x if x == "Cola" => cola
    }

    (drink, Charge(creditCard, drink.costDrink))
  }

}
