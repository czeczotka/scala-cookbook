name := "scala-cookbook"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % Test withSources()
libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19" % Test withSources()

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.7"
libraryDependencies += "org.clapper" % "grizzled-slf4j_2.11" % "1.0.2"