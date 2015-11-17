package com.czeczotka.scala.cookbook.testing

import org.scalatest.{GivenWhenThen, FunSpec}

class PizzaGivenWhenThenSpec extends FunSpec with GivenWhenThen {

  var pizza: Pizza = _

  describe("A Pizza") {

    it("should start with no toppings") {
      Given("a new pizza")
      pizza = new Pizza

      Then("the topping count should be zero")
      assertResult(0)(pizza.getToppings.size)
    }

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

    it("should allow removal of toppings") {
      Given("a new pizza with one topping")
      pizza = new Pizza
      pizza.addTopping(Topping("green olives"))

      When("the topping is removed")
      pizza.removeTopping(Topping("green olives"))

      Then("the topping count should be zero")
      assertResult(0)(pizza.getToppings.size)
    }
  }
}