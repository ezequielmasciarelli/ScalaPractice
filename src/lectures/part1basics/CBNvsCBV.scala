package lectures.part1basics

object CBNvsCBV extends App {

  def callByValue(x:Long): Unit = { //DEFAULT IN IMPERATIVE LANGUAGES
    println(s"By Name: $x")
    println(s"By Name: $x")
  }

  def callByName(x: => Long): Unit = { //LAZY, EVALUATED INSIDE
    println(s"By Name: $x")
    println(s"By Name: $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite():Int = 1 + infinite
  def printFirst(x:Int,y: => Int): Unit = println(x)

  printFirst(23,infinite())
  //printFirst(infinite(),32) Esto rompe, porque infinite no puede ser evaluado
  //LA FLECHA PASA LA EXPRESION TAL COMO ES, NO LA EVALUA
}
