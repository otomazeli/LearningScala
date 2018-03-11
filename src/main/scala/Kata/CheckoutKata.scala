package Kata
// Dan Dixey, 2018 `a` Technical Test / Assessment
// Date: 06/03/2018

case class SKU(sku: String) extends AnyVal

trait CustomValue {

  def value: Int

  def +(that: Price)         = Price(this.value + that.value)
  def +(that: LoyaltyPoints) = LoyaltyPoints(this.value + that.value)

  def -(that: Price)         = Price(this.value - that.value)
  def -(that: LoyaltyPoints) = LoyaltyPoints(this.value - that.value)

  def v: Int = this.value
}
case class Price(value: Int)         extends CustomValue
case class LoyaltyPoints(value: Int) extends CustomValue
case class BasketSize(sku: SKU, count: Int)
case class MissingItemException(msg: String) extends Exception(msg)

trait Discounts {
  def findPrice(n: Int, unitCost: Price): Option[(Price, LoyaltyPoints)]
}

case class MultiBuy(q: Int, p: Price) extends Discounts {
  override def findPrice(n: Int, unitCost: Price): Option[(Price, LoyaltyPoints)] = {
    if (n >= q) {
      val v = (n / q) * p.v + (n % q) * unitCost.v
      Some(Price(v), LoyaltyPoints(v))
    } else {
      val v = unitCost.v * n
      Some(Price(v), LoyaltyPoints(v * 2))
    }
  }
}

trait StoreItem {
  def calculatePrice(n: Int, discount: Option[Discounts]): Option[(Price, LoyaltyPoints)]
}

case class ScannedItem(sku: SKU, price: Price) extends StoreItem {
  override def calculatePrice(n: Int, d: Option[Discounts]): Option[(Price, LoyaltyPoints)] =
    d match {
      case Some(m: MultiBuy) => m.findPrice(n, price)
      case _                 => Some(Price(price.v * n), LoyaltyPoints(price.v * 2))
    }
}

case class MissingItem(sku: SKU) extends StoreItem {
  def apply(sku: SKU): MissingItem = {
    println(s"Item $sku does not exist in the Inventory.\n")
    MissingItem(sku)
  }
  override def calculatePrice(n: Int, d: Option[Discounts]): Option[(Price, LoyaltyPoints)] = None
}

trait InventoryService {
  def get_item(sku: SKU): Option[StoreItem]
}

class BasicStoreInventory(val stock: Map[SKU, ScannedItem]) extends InventoryService {
  override def get_item(sku: SKU): Option[StoreItem] = stock.get(sku)
}

object CheckoutKata {

  def apply(items: List[(SKU, Price)]): BasicStoreInventory =
    new BasicStoreInventory(items.map { case (s, p) => s -> ScannedItem(s, p) }.toMap)

  def uniqueItems(a: List[SKU]): List[BasketSize] =
    a.groupBy(identity).map { case (x, y) => BasketSize(x, y.length) }.toList

  def scanItem(a: SKU, s: InventoryService): Option[StoreItem] = s.get_item(a)

  def calculateCost(i: StoreItem, c: Int, d: Map[SKU, Discounts]): Option[(Price, LoyaltyPoints)] =
    i match {
      case n: ScannedItem => n.calculatePrice(c, d.get(n.sku))
      case _              => None
    }

  def totalCost(item: List[SKU],
                s: InventoryService,
                d: Map[SKU, Discounts]): (Price, LoyaltyPoints) = {
    val output: List[(Price, LoyaltyPoints)] = for {
      item <- uniqueItems(item)
      scan <- scanItem(item.sku, s)
      cost <- calculateCost(scan, item.count, d)
    } yield cost

    output.foldLeft((Price(0), LoyaltyPoints(0))) {
      case ((p1, l1), (p2, l2)) => (p1 + p2, l1 + l2)
    }
  }
}
