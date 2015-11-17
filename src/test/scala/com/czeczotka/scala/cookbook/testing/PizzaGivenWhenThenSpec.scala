package com.czeczotka.scala.cookbook.testing

import org.scalatest.{GivenWhenThen, FunSpec}

class PizzaGivenWhenThenSpec extends FunSpec with GivenWhenThen {

  var pizza: Pizza = _

  describe("A Pizza") {

    it("should allow the addition of toppings") {
      Given("a new pizza")
      pizza = new Pizza

      When("a topping is added")
      pizza.addTopping(Topping("green olives"))

      Then("the topping count should be incremented")
      assertResult(1) {
        pizza.getToppings.size
      }

      And("the topping should be what was added")
      assert(pizza.getToppings.head == Topping("green olives"))
    }
  }
}