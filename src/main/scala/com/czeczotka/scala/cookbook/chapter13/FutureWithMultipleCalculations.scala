package com.czeczotka.scala.cookbook.chapter13

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object FutureWithMultipleCalculations extends App {

  println("starting futures")
  val result1 = runAlgorithm(10)
  val result2 = runAlgorithm(20)
  val result3 = runAlgorithm(30)

  println("before for-comprehension")
  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield r1 + r2 + r3

  println("before onSuccess")
  result onSuccess {
    case total => println(s"total = $total")
  }

  println("before sleep at the end")
  Thread.sleep(2000)

  def runAlgorithm(i: Int) = Future {
    Thread.sleep(Random.nextInt(1000))
    val result = i + 10
    println(s"returning result from cloud: $result")
    result
  }
}