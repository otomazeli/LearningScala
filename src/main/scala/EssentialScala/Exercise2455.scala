package EssentialScala

object Exercise2455 {

  println(alien.greet(person))
}

object person {
  val firstName = "Dan"
  val lastName  = "Dixey"
}

object alien {
  def greet(p: person.type): String =
    "Greetings, " + p.firstName + " " + p.lastName
}
