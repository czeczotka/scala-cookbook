package com.czeczotka.scala.cookbook.chapter13

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

object FutureWithBlocking extends App {

  val f: Future[Int] = Future {
    Thread.sleep(500)
    1 + 1
  }

  val result = Await.result(f, 1 second)
  println(result)

//  Thread.sleep(1000)
}