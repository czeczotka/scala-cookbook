package com.czeczotka.scala.cookbook.chapter13

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object FutureWithOnSuccessAndFailure extends App{

  val f: Future[Int] = Future {
    Thread.sleep(Random.nextInt(500))
    if (Random.nextInt(500) > 250) throw new Exception("Oooups!") else 42
  }

  f onSuccess {
    case result => println(s"Success: $result")
  }

  f onFailure {
    case t => println(s"Exception: ${t.getMessage}")
  }

  println("A... "); Thread.sleep(100)
  println("B... "); Thread.sleep(100)
  println("C... "); Thread.sleep(100)
  println("D... "); Thread.sleep(100)
  println("E... "); Thread.sleep(100)
  println("F... "); Thread.sleep(100)

  Thread.sleep(2000)
}