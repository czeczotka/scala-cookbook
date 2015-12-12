package com.czeczotka.scala.cookbook.chapter02

import scala.util.{Failure, Success, Try}

object Numbers extends App {

  println("Int.MaxValue = " + Int.MaxValue)
  println("Short.MaxValue = " + Short.MaxValue)
  println("\"3\".toDouble = " + "3".toDouble)
  println("Integer.parseInt(\"100\", 2) = " + Integer.parseInt("100", 2))
  println("\"111\".toInt(2) = " + "111".toInt(2))

  val result = "210".toInt(2) match {
    case Success(int: Int) => println(s"Got $int")
    case Failure(ex) => println(s"No luck converting to integer: $ex")
  }

  implicit class String2Int(s: String) {
    def toInt(radix: Int): Try[Int] = Try(Integer.parseInt(s, radix))
  }
}