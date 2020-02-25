package lectures.part3fp

object AnonymousFunctions extends App {

  //Still OOP, Ugly
  val doublerUgly = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1 *2
  }

  //LAMBDA == Anonymous Function
  val doubler : Int => Int = x => x * 2
  val doubler2 = (x : Int) => x * 2
  val adder : (Int,Int) => Int = (a: Int, b: Int) => a + b
  val doSomething : () => Int = () => 3
  val doSomething2 = () => 3

  println(doSomething) //Function
  println(doSomething()) //Call of the function

  //curly braces
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //MOAR sintactic sugar
  val niceIncrementer : Int => Int = (x: Int) => x + 1
  val niceIncrementer2 : Int => Int = _ + 1 // == x => x + 1
  val niceAdder : (Int,Int) => Int = _ + _ //each underscore is a different argument, TYPE is needed

  /*
  1. MyList, replace FunctionX with lambdas
  2. Rewrite curryAdder as AnonymousFunction
   */

  val curryAdder : Int => Int => Int = a => b => a + b
  val curryAdderNicer = (x : Int) => (y: Int) => x + y

}
