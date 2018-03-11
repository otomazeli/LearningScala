package Kata
// Dan Dixey, 2018 `a` Technical Test / Assessment
// Date: 06/03/2018
import org.scalatest._

class CheckoutKataSpec extends FlatSpec with Matchers {

  // Example Inventories
  val inv_one = CheckoutKata(List())
  val inv_two = CheckoutKata(
    List((SKU("A"), Price(50)),
         (SKU("B"), Price(30)),
         (SKU("C"), Price(20)),
         (SKU("D"), Price(15))))

  // Test Discounts
  val discount_two =
    Map(SKU("A") -> MultiBuy(3, Price(120)), SKU("B") -> MultiBuy(2, Price(45)))

  "An Empty Basket" should "return 0" in {
    CheckoutKata.totalCost(List(), inv_one, Map()) should be(Price(0), LoyaltyPoints(0))
    CheckoutKata.totalCost(List(), inv_two, Map()) should be(Price(0), LoyaltyPoints(0))
  }

  "Missing Items" should "return 0" in {
    CheckoutKata.totalCost(List(SKU("F")), inv_one, Map()) should be(Price(0), LoyaltyPoints(0))
    CheckoutKata.totalCost(List(SKU("G")), inv_two, Map()) should be(Price(0), LoyaltyPoints(0))
  }

  "Insufficient demand to meet discount threshold" should
    "return 0 and 45" in {
    CheckoutKata.totalCost(List(SKU("A"), SKU("C"), SKU("A")), inv_one, discount_two) should be(
      Price(0),
      LoyaltyPoints(0))
    CheckoutKata.totalCost(List(SKU("D"), SKU("B")), inv_two, discount_two) should be(
      Price(45),
      LoyaltyPoints(90))
  }

  "Sufficient demand to meet discount threshold" should
    "return prices that have been discounted" in {
    CheckoutKata.totalCost(List(SKU("A"), SKU("D"), SKU("A"), SKU("C"), SKU("A")),
                           inv_two,
                           discount_two) should be(Price(155), LoyaltyPoints(190))
    CheckoutKata.totalCost(List(SKU("B"), SKU("B")), inv_two, discount_two) should be(
      Price(45),
      LoyaltyPoints(45))
    CheckoutKata.totalCost(List(SKU("B"), SKU("B"), SKU("B")), inv_two, discount_two) should be(
      Price(75),
      LoyaltyPoints(75))
  }

  "Test example" should "return 95" in {
    CheckoutKata.totalCost(List(SKU("B"), SKU("A"), SKU("B")), inv_two, discount_two) should be(
      Price(95),
      LoyaltyPoints(145))
  }

  // TODO: Add more Tests for the Loyalty Points x2
}
