package com.czeczotka.scala.cookbook.testing

import scala.collection.mutable.ArrayBuffer

class Pizza {

  private val toppings = new ArrayBuffer[Topping]

  def addTopping(t: Topping) {
    toppings += t
  }

  def removeTopping(t: Topping) {
    toppings -= t
  }

  def getToppings = toppings.toList

  def boom {
    throw new Exception("Boom!")
  }
}