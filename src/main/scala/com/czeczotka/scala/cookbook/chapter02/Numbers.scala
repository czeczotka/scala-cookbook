package com.czeczotka.scala.cookbook.chapter02

import scala.util.{Failure, Success, Try}

object Numbers extends App {

  parsingANumberFromAString_2_1()
  convertingBetweenNumericTypes_2_2()
  overrideTheDefaultNumericType_2_3()
  comparingFloatingPointNumbers_2_5()

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

  def overrideTheDefaultNumericType_2_3() = {
    val long1 = 1000: Long
    val long2: Long = 2000
    val hex1: Long = 0xFF
    val hex2: Long = 0x100
    println("2.3 Overriding the Default Numeric Type")
    println("long1.getClass = " + long1.getClass)
    println("long2.getClass = " + long2.getClass)
    println("hex1 = " + hex1)
    println("hex2 = " + hex2)
    println()
  }

  def comparingFloatingPointNumbers_2_5() = {
    def ~=(x: Double, y: Double, precision: Double) = {
      if ((x - y).abs < precision) true else false
    }
    
    val a = 0.3
    val b = 0.1 + 0.2

    println("2.5 Comparing Floating-Point Numbers")
    println("(a == b) = " + (a == b))
    println("~=(a, b, 0.00000000001) = " + ~=(a, b, 0.00000001))
  }

  implicit class String2Int(s: String) {
    def toInt(radix: Int): Try[Int] = Try(Integer.parseInt(s, radix))
  }
}