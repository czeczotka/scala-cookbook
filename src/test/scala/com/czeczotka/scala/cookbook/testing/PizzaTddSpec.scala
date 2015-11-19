package com.czeczotka.scala.cookbook.testing

import com.czeczotka.scala.cookbook.Tdd
import org.scalatest.{BeforeAndAfter, FunSuite}

class PizzaTddSpec extends FunSuite with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  test("new pizza has no toppings", Tdd) {
    assert(pizza.getToppings.isEmpty)
  }

  test("adding one topping", Tdd) {
    pizza.addTopping(Topping("green olives"))
    assert(pizza.getToppings.size == 1)
  }

  test("catching an exception", Tdd) {
    val exception = intercept[Exception] {
      pizza.boom
    }
    assert(exception.isInstanceOf[Exception])
    assert(exception.getMessage == "Boom!")
  }

  test("catching another exception", Tdd) {
    intercept[Exception] {
      pizza.boom
    } match {
      case ex: Exception => assert(ex.getMessage == "Boom!")
    }
  }

  test("catching yet another exception", Tdd) {
    intercept[Exception] {
      pizza.boom
    }
  }

  test("test pizza pricing", Tdd) (pending)

  ignore("test ignore", Tdd) (pending)

}