package com.czeczotka.scala.cookbook.testing

import org.scalatest.{BeforeAndAfter, FunSuite}

class PizzaSpec extends FunSuite with BeforeAndAfter {

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

  test("test pizza pricing") (pending)

}