package EssentialScala

object Exercise264 {
  // A Classic Rivalry: What is the type and value of the following conditional?
  val a: String = if (1 > 2) "alien" else "predator"

  // A Less Well Known Rivalry: What about this conditional?
  val b: Any = if (1 > 2) "alien" else 2001

  // An if Without an else: What about this conditional?
  val c: Any = if (false) "hello"

}
