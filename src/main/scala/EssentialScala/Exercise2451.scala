package EssentialScala

// Cat-o-ma que
//    The table below shows the names, colour, and favourite foods of three cats. Define an object for each cat. (For
//    experienced programmers: we haven’t covered classes yet.)

object Oswald {
  val colour = "Black"
  val food   = "Milk"
}

object Quintin {
  val colour = "Tabby and white"
  val food   = "Curry"
}

object Henderson {
  val colour = "Ginger"
  val food   = "Chips"
}

object Exercise245 {
  println(Oswald.colour, Oswald.food)
  println(Quintin.colour, Quintin.food)
  println(Henderson.colour, Henderson.food)
}
