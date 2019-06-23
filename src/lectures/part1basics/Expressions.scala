package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 //Expresion
  println(x)
  println(1 + 2 * 3)
  println(1==x)
  println(!(1==x))

  var aVar = 4 //Side efect! En la programacion funcional no se desea
  aVar += 1
  println(aVar)

  //Instructions vs Expresions (FUNCIONAL) IMPORTANTE
  //Instructions (Le decimos a la computadora que HACER) DO something
  //Expresions (VALUE) Programacion funcional, las cosas computan a un valor

  val aCondition = true
  val value = if(aCondition) 5 else 3 //If expression, porque retorna valores!, No es una if instruction de java
  println(value)

  println(if(aCondition) 4 else 2) //IF IN SCALA IS AN EXPRESSION

  //LOOPS EXIST IN SCALA BUT THEY ARE DISCOURAGED, because they do side effects

  var i = 0
  val aWhile = while (i<10) { //Whiles do side effects, so they return unit
    println(i)
    i+=1
  }
  //NEVER WRITE THIS AGAIN! THIS IS IMPERATIVE PROGRAMMING, NOT FUNCTIONAL
  //USE EXPRESSIONS, NOT INSTRUCTIONS
  //EVERYTHING IN SCALA IS AN EXPRESSION

  val aWeirdValue = (aVar = 3) //Unit === void, do not return anything meaningful
  println(aWeirdValue) //El unico valor que puede tener unit es ()

  //Side effect: println(), whiles, reassigning. Imperative programming

  //Code Blocks they are expressions
  val aCode = {
    val y = 2
    val z = y + 1
    if(z > 2) "hello" else "goodbye"
  } //THE VALUE of the code block is the value of the last expression

  //Instructions are executed, Expressions are evaluated
  //Instructions, do something
  //Expressions, give me the value of something

  val someVal = {
    2 < 3
  }

  println(someVal)

  val someOtherVal = {
    if(someVal) 2 else 5
    30 //retorna esto, la linea de arriba es completamente irrelevante
  }

  println(someOtherVal)

}
