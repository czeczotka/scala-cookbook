// Case 1: uninitialized val field

trait PizzaTrait1 {
  val maxNumToppings: Int
}

class Pizza1 extends PizzaTrait1 {
  val maxNumToppings = 10 // 'override' is not required
}

// Case 2: initialized val field
trait PizzaTrait2 {
  val maxNumToppings = 10
}

class Pizza2 extends PizzaTrait2 {
  override val maxNumToppings = 11 // 'override' is required
}

(new Pizza1).maxNumToppings
(new Pizza2).maxNumToppings
