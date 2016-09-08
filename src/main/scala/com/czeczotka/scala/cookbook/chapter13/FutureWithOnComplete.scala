package com.czeczotka.scala.cookbook.chapter13

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success}

object FutureWithOnComplete extends App {

  val f: Future[Int] = Future {
    Thread.sleep(Random.nextInt)
    42
  }

  println("Await.result() = " + Await.result(f, 1 second))

  println("before onComplete")
  f.onComplete {
    case Success(value) => println("value = " + value)
    case Failure(ex) => println("ex = " + ex)
  }

  println("A... "); Thread.sleep(100)
  println("B... "); Thread.sleep(100)
  println("C... "); Thread.sleep(100)
  println("D... "); Thread.sleep(100)
  println("E... "); Thread.sleep(100)
  println("F... "); Thread.sleep(100)

  Thread.sleep(2000)
}
