val divide = new PartialFunction[Int, Int] {
  def apply(x: Int) = 42 / x
  def isDefinedAt(x: Int): Boolean = x != 0
}

val divide2: PartialFunction[Int, Int] = {
  case d: Int if d != 0 => 42 / d
}

divide(1)
divide.isDefinedAt(0)
divide.isDefinedAt(1)

divide2(1)
divide2.isDefinedAt(0)
divide2.isDefinedAt(1)

/*
chaining partial functions:
   orElse - Composes this partial function with a fallback partial function
            which gets applied where this partial function is not defined.
   andThen - Composes this partial function with a transformation function
             that gets applied to results of this partial function.
 */

var convert1to5 = new PartialFunction[Int, String] {
  val nums = Array("one", "two", "three", "four", "five")
  def apply(i: Int) = nums(i - 1)
  def isDefinedAt(i: Int): Boolean = i > 0 && i < 6
}
var convert6to10 = new PartialFunction[Int, String] {
  val nums = Array("six", "seven", "eight", "nine", "ten")
  def apply(i: Int) = nums(i - 6)
  def isDefinedAt(i: Int): Boolean = i > 5 && i < 11
}

val handle1to10 = convert1to5 orElse convert6to10
val handleAll = handle1to10 orElse new PartialFunction[Int, String] {
  def apply(i: Int) = s"unknown for $i"
  def isDefinedAt(i: Int): Boolean = true
}

handle1to10(7)
handle1to10.isDefinedAt(2)
handle1to10.isDefinedAt(12)

handleAll(7)
handleAll(17)
handleAll.isDefinedAt(2)
handleAll.isDefinedAt(12)