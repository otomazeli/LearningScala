package ImpatientScala

/**
  * Classes - Chapter 5
  */
object Chapter5Main extends App {

  println(
    "1. Improve the Counter class in Section 5.1 , 'Simple Classes and Parameterless Methods,' Improve the " +
      "Counter class in Section 5.1 , “Simple Classes and Parameterless Methods,”"
  )
  class MyCounter(private var value: Int) {
    def increment() {
      if (value + 1 <= Int.MaxValue) {
        value += 1
      }
    }
    def current: Int = value
  }
  val a1 = new MyCounter(4)
  println(a1.current.toString)
  println()

  println(
    "2. Write a class BankAccount with methods deposit and withdraw, and a read-only property balance."
  )
  class BankAccount(private var _balance: Double = 0.0) {

    def deposit(value: Int): Unit = {
      _balance += value
    }

    def deposit(value: Double): Unit = {
      _balance += value
    }

    def withdraw(value: Int): Unit = {
      if (_balance - value > 0) {
        _balance -= value
      }
    }

    def withdraw(value: Double): Unit = {
      if (_balance - value > 0) {
        _balance -= value
      }
    }

    def balance: Double = _balance

  }
  val myBank: BankAccount = new BankAccount
  myBank.deposit(1000)
  myBank.withdraw(299.12)
  myBank.withdraw(41.12)
  println(s"My Balance: ${myBank.balance}")
  println()

  println(
    "3. Write a class Time with read-only properties hours and minutes and a method before(other: Time):" +
      "Boolean that checks whether this time comes before the other. " +
      "A Time object should be constructed as new Time(hrs, min), where hrs is in military time format " +
      "(between 0 and 23)."
  )
  println()

  println(
    "4. Reimplement the Time class from the preceding exercise so that the internal representation is " +
      "the number of minutes since midnight (between 0 and 24 × 60 – 1). " +
      "Do not change the public interface. That is, client code should be unaffected by your change."
  )
  println()

  println(
    "5. Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long)." +
      "What methods are generated? (Use javap to check.) Can you call the JavaBeans getters and setters in Scala?"
  )
  println()

  println(
    "6. In the Person class of Section 5.1 , “Simple Classes and Parameterless Methods,” on page 49 , " +
      "provide a primary constructor that turns negative ages to 0."
  )
  println()

  println(
    "7. Write a class Person with a primary constructor that accepts a string containing a first name, a space, " +
      "and a last name, such as new Person('Fred Smith') . Supply read-only properties firstName and lastName. " +
      "Should the primary constructor parameter be a var , a val , or a plain parameter? Why?"
  )
  println()

  println(
    "8. Make a class Car with read-only properties for manufacturer, model name, and model year, and a " +
      "read-write property for the license plate." +
      "Supply four constructors. All require the manufacturer and model name. Optionally, model year and license " +
      "plate can also be specified in the constructor. If not, the model year is set to -1 and the license plate" +
      " to the empty string. Which constructor? Why?"
  )
  println()

  println(
    "9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice). How much " +
      "shorter is the Scala class?"
  )
  println()

  println(
    "10. Consider the class " +
      "class Employee(val name: String, var salary: Double) {def this() { this('John Q. Public', 0.0) } }" +
      "Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?"
  )

}
