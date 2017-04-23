package dbiz.chapter1.extended

abstract class Drink (name: String, typeDrink: String, value: Double) {
  val nameDrink: String = name
  val categoryDrink: String = typeDrink
  var costDrink: Double = value
  def showName() { println(nameDrink) }
  override def toString = s"\n\t\t\tName of Drink: $nameDrink, Type of Drink: $categoryDrink, Cost: $costDrink"
}

class Coffee (name: String, value: Double) extends Drink (name, typeDrink = "Coffee", value) {
  val colour = "Dark Brown"
}

class Tea (name: String, value: Double) extends Drink (name, typeDrink = "Tea", value) {
  val colour = "Clear"
}

class Fizzy (name: String, value: Double) extends Drink (name, typeDrink = "Fizzy Drink", value) {
  val colour = "Varied"
}
