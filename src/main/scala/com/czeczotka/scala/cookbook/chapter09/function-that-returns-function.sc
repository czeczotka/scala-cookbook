// a function that returns an anonymous function
def saySomething(prefix: String): String => String =
  (s: String) => { prefix + " " + s }

val hello = saySomething("Hello")
hello("world")

saySomething("Hola")("Mundo")