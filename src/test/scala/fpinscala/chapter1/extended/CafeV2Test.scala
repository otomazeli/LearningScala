package Chapter1

import dbiz.chapter1.extended.{CafeV2, Coffee}
import dbiz.chapter1.original.CreditCard
import org.scalatest._

class CafeV2Test extends FlatSpec with Matchers {

  "CafeV2Test.buy a Cola" should "purchase a Cola correctly" in {
    val (drinkChoice, charge) = new CafeV2().buyDrink(new CreditCard, "Cola")
    assert(drinkChoice.costDrink == 2.55)
    assert(drinkChoice.nameDrink == "Cola")
    assert(charge.amount == new Coffee("Cola", 2.55).costDrink)
  }

  "CafeV2Test.buy a Cortado" should "purchase a Cortado correctly" in {
    val (drinkChoice, charge) =
      new CafeV2().buyDrink(new CreditCard, "Cortado")
    assert(drinkChoice.costDrink == 1.75)
    assert(drinkChoice.nameDrink == "Cortado")
    assert(charge.amount == new Coffee("Cortado", 1.75).costDrink)
  }

  "CafeV2Test.buy a Expresso" should "purchase a Expresso correctly" in {
    val (drinkChoice, charge) =
      new CafeV2().buyDrink(new CreditCard, "Expresso")
    assert(drinkChoice.costDrink == 1.95)
    assert(drinkChoice.nameDrink == "Expresso")
    assert(charge.amount == new Coffee("Cola", 1.95).costDrink)
  }

  "CafeV2Test.buy a Lady Grey" should "purchase a Lady Grey correctly" in {
    val (drinkChoice, charge) =
      new CafeV2().buyDrink(new CreditCard, "Lady Grey")
    assert(drinkChoice.costDrink == 2.15)
    assert(drinkChoice.nameDrink == "Lady Grey")
    assert(charge.amount == new Coffee("Lady Grey", 2.15).costDrink)
  }

  "CafeV2Test.buy Multiple Drinks" should "purchase many drinks correctly - Lady Grey, Cola, Expresso, Cortado" in {
    val drinksList = List("Lady Grey", "Cola", "Expresso", "Cortado")
    val myCard = new CreditCard
    val (drinks, charge) = new CafeV2().buyDrinks(myCard, drinksList)
    assert(
      drinks.map(x => x.nameDrink) == List("Lady Grey",
                                           "Cola",
                                           "Expresso",
                                           "Cortado"))
    assert(charge.amount == 8.399999999999999)
    val counts = drinks
      .map(x => x.categoryDrink)
      .groupBy(identity)
      .mapValues(_.size)
    assert(counts == Map("Tea" -> 1, "Coffee" -> 2, "Fizzy Drink" -> 1))
  }

  "CafeV2Test.buy Crazy Amounts" should "purchase so many drinks correctly" in {
    // Buy Many Drinks in one Session
    val ladys = List.fill(1000)("Lady Grey")
    val colas = List.fill(2400)("Cola")
    val expressos = List.fill(100)("Expresso")
    val cortados = List.fill(900)("Cortado")
    val drinksList = List(ladys, colas, expressos, cortados).flatten
    val myCard = new CreditCard
    // Calculate the Drinks bill
    val (drinks, charge) = new CafeV2().buyDrinks(myCard, drinksList)
    assert(charge.amount == 10040.000000000522)
    val counts =
      drinks.map(x => x.categoryDrink).groupBy(identity).mapValues(_.size)
    assert(
      counts == Map("Tea" -> 1000, "Coffee" -> 1000, "Fizzy Drink" -> 2400))
  }

}
