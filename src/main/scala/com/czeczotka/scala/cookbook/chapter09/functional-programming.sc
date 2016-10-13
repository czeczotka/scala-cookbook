val list = List(1, 2, 3)

// function value
val double = (i: Int) => { i * 2 }
double(3)

def triple(i: Int) = i * 3
def add(x: Int, y: Int) = x + y

list map double
list map triple

// partially applied function - its one arg has not been supplied yet
val myTriple = triple(_)
val myAdd = add(_,_)
myAdd(myTriple(-3), triple(-2))


// return nothing
def plusOne(i: Int): Unit = i + 1
plusOne(2)

def executeXTimes(callback: () => Unit, numTimes: Int): Unit = {
  for (i <- 1 to numTimes) callback()
}

val sayHello = () => println("hello")
executeXTimes(sayHello, 3)