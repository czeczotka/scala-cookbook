package com.czeczotka.scala.cookbook.testing

import org.slf4j.LoggerFactory
import scala.collection.mutable.ArrayBuffer

class Pizza {

  private val toppings = new ArrayBuffer[Topping]
  private val logger = LoggerFactory.getLogger(classOf[Pizza])

  logger.info("Creating a new pizza")

  def addTopping(t: Topping) {
    logger.info(s"Adding $t")
    toppings += t
  }

  def removeTopping(t: Topping) {
    logger.info(s"Removing $t")
    toppings -= t
  }

  def getToppings = toppings.toList

  def boom {
    throw new Exception("Boom!")
  }
}