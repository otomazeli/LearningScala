name := "LearningScala"
version := "1.0"
scalaVersion := "2.12.4"

val configVersion = "1.3.1"
val scala_test = "3.0.4"

libraryDependencies ++= Seq(
  // Configuration Files
  "com.typesafe" % "config" % configVersion,
  // ScalaTest Framework
  "org.scalatest" %% "scalatest" % scala_test
)

lazy val defaultSettings = Defaults.coreDefaultSettings ++ Seq(
  resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
)

parallelExecution in ThisBuild := true
