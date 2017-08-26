name := "ImpatientScalaAnd99Problems"
version := "1.0"
scalaVersion := "2.12.3"

val configVersion = "1.3.0"

libraryDependencies ++= Seq(
  // Configuration Files
  "com.typesafe" % "config" % configVersion,
  "org.scalatest" %% "scalatest" % "3.0.0"
)

lazy val defaultSettings = Defaults.coreDefaultSettings ++ Seq(
  resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
)
