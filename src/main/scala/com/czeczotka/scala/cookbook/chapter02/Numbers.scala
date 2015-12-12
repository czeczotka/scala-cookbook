package com.czeczotka.scala.cookbook.chapter02

import scala.util.{Failure, Success, Try}

object Numbers extends App {

  parsingANumberFromAString_2_1()
  convertingBetweenNumericTypes_2_2()

  def parsingANumberFromAString_2_1() = {
    println("2.1 Parsing a Number from a String")
    println("Int.MaxValue = " + Int.MaxValue)
    println("Short.MaxValue = " + Short.MaxValue)
    println("\"3\".toDouble = " + "3".toDouble)
    println("Integer.parseInt(\"100\", 2) = " + Integer.parseInt("100", 2))
    println("\"111\".toInt(2) = " + "111".toInt(2))

    "210".toInt(2) match {
      case Success(int: Int) => println(s"Got $int")
      case Failure(ex) => println(s"No luck converting to integer: $ex")
    }
    println()
  }

  def convertingBetweenNumericTypes_2_2() = {
    println("2.2 Converting between numeric types")
    println("Byte.MaxValue = " + Byte.MaxValue)
    println("Byte.MaxValue.toFloat = " + Byte.MaxValue.toFloat)
    println("(Byte.MaxValue + 1).toByte = " + (Byte.MaxValue + 1).toByte)
    println("(Byte.MaxValue + 1).isValidByte = " + (Byte.MaxValue + 1).isValidByte)
    println()
  }

  implicit class String2Int(s: String) {
    def toInt(radix: Int): Try[Int] = Try(Integer.parseInt(s, radix))
  }
}