package com.czeczotka.scala.cookbook.testing

import org.scalatest.{BeforeAndAfter, FunSuite}

class PizzaTddSpec extends FunSuite with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  test("new pizza has no toppings") {
    assert(pizza.getToppings.isEmpty)
  }

  test("adding one topping") {
    pizza.addTopping(Topping("green olives"))
    assert(pizza.getToppings.size == 1)
  }

  test("catching an exception") {
    val exception = intercept[Exception] {
      pizza.boom
    }
    assert(exception.isInstanceOf[Exception])
    assert(exception.getMessage == "Boom!")
  }

  test("catching another exception") {
    intercept[Exception] {
      pizza.boom
    } match {
      case ex: Exception => assert(ex.getMessage == "Boom!")
    }
  }

  test("catching yet another exception") {
    intercept[Exception] {
      pizza.boom
    }
  }

  test("test pizza pricing") (pending)

}