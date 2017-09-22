package ImpatientScala

import scala.beans.BeanProperty

/**
  * Classes - Chapter 5
  */
object Chapter5Main {

  println(
    "1. Improve the Counter class in Section 5.1 , 'Simple Classes and Parameterless Methods,' Improve the " +
      "Counter class in Section 5.1 , “Simple Classes and Parameterless Methods,”"
  )
  class myCounter(private var value: Int) {
    def increment(): Unit = {
      if (value + 1 <= Int.MaxValue) {
        value += 1
      }
    }
    def current: Int = value
  }
  val a1 = new myCounter(4)
  println(a1.current.toString)
  println()

  println(
    "2. Write a class BankAccount with methods deposit and withdraw, and a read-only property balance."
  )
  class bankAccount(private var _balance: Double = 0.0) {

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
  val myBank: bankAccount = new bankAccount
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
  class time3(private var _hrs: Int, private var _min: Int) {
    _min = _min match {
      case i: Int if i % 60 == 0 => _hrs += i / 60; 0
      case i: Int if i < 0  => _hrs += (i / 60 - 1); 60 + i % 60
      case i: Int if i > 59 => _hrs += i / 60; i % 60
      case _                => _min
    }
    _hrs = _hrs match {
      case i: Int if i < 0  => 24 + i % 24
      case i: Int if i > 23 => i % 24
      case _                => _hrs
    }

    def hrs: Int = _hrs
    def min: Int = _min
    def before(other: time3): Boolean = {
      _hrs < other._hrs || (other._hrs == _hrs && _min < other._min)
    }
  }

  val aT1 = new time3(-1, 70)
  val aT2 = new time3(2, -59)
  println(s"Time ${aT1.hrs}, ${aT1.min}, ${aT2.before(aT1)}")
  println()

  println(
    "4. Reimplement the Time class from the preceding exercise so that the internal representation is " +
      "the number of minutes since midnight (between 0 and 24 × 60 – 1). " +
      "Do not change the public interface. That is, client code should be unaffected by your change."
  )
  class time4(private var _hrs: Int, private var _min: Int) {

    _min = _min match {
      case i: Int if i % 60 == 0 => _hrs += i / 60; 0
      case i: Int if i < 0  => _hrs += (i / 60 - 1); 60 + i % 60
      case i: Int if i > 59 => _hrs += i / 60; i % 60
      case _                => _min
    }

    _hrs = _hrs match {
      case i: Int if i < 0  => 24 + i % 24
      case i: Int if i > 23 => i % 24
      case _                => _hrs
    }

    def hrs: Int = _hrs
    def min: Int = _min
    def before(other: time4): Boolean = {
      _hrs < other._hrs || (other._hrs == _hrs && _min < other._min)
    }

  }

  val aT3 = new time4(1, -70)
  val aT4 = new time4(2, -59)
  println(s"Time ${aT3.hrs}, ${aT3.min}, ${aT4.before(aT3)}")
  println()

  println(
    "5. Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long)." +
      "What methods are generated? (Use javap to check.) Can you call the JavaBeans getters and setters in Scala?"
  )
  class Student(@BeanProperty var name: String, @BeanProperty var id: Long)
  val john = new Student("John", 2457)
  println(john.id, john.name, john.getId == john.id)
  println()

  println(
    "6. In the Person class of Section 5.1 , “Simple Classes and Parameterless Methods,” on page 49 , " +
      "provide a primary constructor that turns negative ages to 0."
  )
  class Person(private var _age: Int) {

    if (_age < 0) _age = 0

    def age: Int = _age
    def age_=(newValue: Int): Unit = {
      if (newValue > _age) _age = newValue
    }
  }
  val Paul = new Person(-2)
  println(Paul.age)
  println()

  println(
    "7. Write a class Person with a primary constructor that accepts a string containing a first name, a space, " +
      "and a last name, such as new Person('Fred Smith') . Supply read-only properties firstName and lastName. " +
      "Should the primary constructor parameter be a var , a val , or a plain parameter? Why?"
  )
  class Person7(_fullName: String) {
    val (firstName, lastName) = _fullName.split(" ") match {
      case Array(x: String, y: String, _*) => (x, y)
      case _                               => (null, null)
    }
  }

  val fredSmith = new Person7("Fred Smith")
  println(fredSmith.firstName, fredSmith.lastName)
  println()

  println(
    "8. Make a class Car with read-only properties for manufacturer, model name, and model year, and a " +
      "read-write property for the license plate." +
      "Supply four constructors. All require the manufacturer and model name. Optionally, model year and license " +
      "plate can also be specified in the constructor. If not, the model year is set to -1 and the license plate" +
      " to the empty string. Which constructor? Why?"
  )
  class Car(val manufacturer: String, val modelName: String) {

    var licencePlate: String    = ""
    private var _modelYear: Int = -1

    def this(manufacturer: String, modelName: String, modelYear: Int) {
      this(manufacturer, modelName)
      this._modelYear = modelYear
    }

    def this(manufacturer: String, modelName: String, licencePlate: String) {
      this(manufacturer, modelName)
      this.licencePlate = licencePlate
    }

    def this(manufacturer: String, modelName: String, modelYear: Int, licencePlate: String) {
      this(manufacturer, modelName)
      this._modelYear = modelYear
      this.licencePlate = licencePlate
    }

    def modelYear: Int = _modelYear
  }

  val VWGolf      = new Car("Volkswagen", "Golf")
  val VWGolf2009  = new Car("Volkswagen", "Golf", 2009)
  val VWGolfPlate = new Car("Volkswagen", "Golf", 2012, "IM NOT TELLING YOU")
  println(VWGolfPlate.manufacturer,
          VWGolfPlate.modelName,
          VWGolfPlate.modelYear,
          VWGolfPlate.licencePlate)
  println()

  println(
    "9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice). How much " +
      "shorter is the Scala class?"
  )
  println("Python?!")
  println()

  println(
    "10. Consider the class " +
      "class Employee(val name: String, var salary: Double) {def this() { this('John Q. Public', 0.0) } }" +
      "Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?"
  )
  class Employee(val name: String, var salary: Double) {
    def this() { this("John Q. Public", 0.0) }
  }
  // A more syntactic form
  class EmployeeRewritten(val name: String = "John Q. Public", var salary: Double = 0.0) {}

}
