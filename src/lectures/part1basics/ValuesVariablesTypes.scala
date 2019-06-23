package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 32
  val y = 32
  println(x)
  //VALS ARE IMMUTABLE
  //Compiler can infer types

  val aString: String = "Hello World"
  val aBoolean: Boolean = true
  val aChar: Char = 'c'
  val anInt: Int = x
  val aShort: Short = 233
  val aLong: Long = 233333333222222222L
  val aFloat: Float = 2.00f
  val aDouble: Double = 3.14

  //var variables
  var aVariable: Int = 3 //Side effect, la programacion funcional trata de eliminarlas
  aVariable = 5



}
