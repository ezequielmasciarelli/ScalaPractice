package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello I Am Learning Scala"

  println(str.charAt(0))
  println(str.substring(6,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","_"))
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)
  println(str.reverse)
  println(str.take(2))


  //Scala-Specific : String Interpolation

  //S-Interpolators
  val name = "Eze"
  val age = 23
  val greeting = s"Hello, my name is $name and I Am ${age + 1} years old"
  println(greeting)

  //F-Interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline")
  val escape = "This is a \n newline"
  println(raw"$escape")
}
