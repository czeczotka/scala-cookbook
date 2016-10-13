// def also works
// def sum(a: Int, b: Int, c: Int) = a + b + c
val sum = (a: Int, b: Int, c: Int) => a + b + c
val f = sum(1, 2, _: Int)

f(3)