package EssentialScala

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

object Draw {
  def apply(shape: Shape): String = shape match {
    case Rectangle(width, height) =>
      s"A rectangle of width ${width}cm and height ${height}cm"
    case Square(size) =>
      s"A square of size ${size}cm"
    case Circle(radius) =>
      s"A circle of radius ${radius}cm"
  }
}

final case class Circle(radius: Double) extends Shape {
  val sides: Int        = 1
  val perimeter: Double = 2 * math.Pi * radius
  val area: Double      = math.Pi * radius * radius
}

final case class Rectangle(width: Double, height: Double) extends Shape {
  val sides: Int        = 4
  val perimeter: Double = 2 * width + 2 * height
  val area: Double      = width * height
}

final case class Square(size: Double) extends Shape {
  val sides: Int        = 4
  val perimeter: Double = 4 * size
  val area: Double      = size * size
}

sealed trait Rectangular extends Shape {
  def width: Int
  def height: Int
  val sides: Int        = 4
  val perimeter: Double = 2 * width + 2 * height
  val area: Double      = width * height
}

final case class Square2(size: Int) extends Rectangular {
  val width: Int  = size
  val height: Int = size
}

final case class Rectangle2(width: Int, height: Int) extends Rectangular
