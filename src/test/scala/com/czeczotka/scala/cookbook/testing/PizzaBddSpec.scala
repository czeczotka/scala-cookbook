package com.czeczotka.scala.cookbook.testing

import org.scalatest.{BeforeAndAfter, FunSpec}

class PizzaBddSpec extends FunSpec with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  describe("A Pizza") {

    it("should start with no toppings") {
      assert(pizza.getToppings.isEmpty)
    }

    it("should allow addition of toppings") (pending)

    it("should allow removal of toppings") (pending)

    ignore("should be ignored") (pending)

  }

}