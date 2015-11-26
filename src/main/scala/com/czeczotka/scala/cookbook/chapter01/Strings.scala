package com.czeczotka.scala.cookbook.chapter01

import scala.collection.immutable.Nil
import com.czeczotka.scala.cookbook.chapter01.utils.StringImprovements

object Strings extends App {

  testingStringEquality_1_1()
  processingAStringOneCharacterAtATime_1_5()
  findingPatternsInStrings_1_6()
  replacingPatternsInStrings_1_7()
  addOwnBehaviourToString_1_10()

  def testingStringEquality_1_1() {
    def line(first: String, second: String) = {
      s"($first == $second) => ${first == second}"
    }
    println("1.1 Testing String equality:")
    println(line("a", "b"))
    println(line("a", "a"))
    println(line(null, "a"))
    println(line(null, null))
    println()
  }

  def processingAStringOneCharacterAtATime_1_5() {
    println("1.5 Processing a String one character at a time")
    for (c <- "hello") print(s"$c ")
    println()

    val result = for {
      c <- "hello, world"
      if c != 'l'
    } yield c.toUpper
    println(result)
    println()
  }

  def findingPatternsInStrings_1_6() {
    println("1.6 Findings patterns in Strings")

    val numPattern = "[0-9]+".r
    val address = "123 Main Street Suite 101"
    val match1 = numPattern.findFirstIn(address)
    val matches = numPattern.findAllIn(address).toList

    match1.foreach { e =>
      print("Found " + e)
    }
    println()

    match1 match {
      case Some(x) => println("Found " + x)
      case None => println("Found none")
    }

    matches match {
      case Nil => println("Found none")
      case _ => println("Found " + matches.mkString("[", ",", "]"))
    }
    println()
  }

  def replacingPatternsInStrings_1_7() {
    println("1.7 Replacing patterns in strings")

    println("123 Main Street".replaceAll("[0-9]", "X"))
    println("H".r.replaceFirstIn("Hello world!", "J"))
    println("Hello world!".replaceFirst("H", "J"))
    println()
  }

  def addOwnBehaviourToString_1_10() {
    println("1.10 Add Your Own Methods to the String class")

    val s = "HAL"
    println(s"s =           $s")
    println(s"s.increment = ${s.increment}")
    println()
  }
}