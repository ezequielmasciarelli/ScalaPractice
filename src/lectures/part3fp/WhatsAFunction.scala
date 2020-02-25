package lectures.part3fp

object WhatsAFunction extends App {

  // use functions as first class elements (as values)
  // at oop everything is an object

  val doubler = new MyFunction[Int,Int] {
    override def apply(elem: Int): Int = elem * 2
  }

  //Scala offers Function1 to Function22 out of the box

  val doubler2 = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  //or we can use the syntactic sugar
  val doubler3 : Int => Int = _ * 2

  println(doubler(2)) //use the apply method implicit
  println(doubler2(2)) //use the apply method implicit
  println(doubler3(2)) //use the apply method implicit

  //adder type ((Int,Int) => Int) //These are function TYPES
  val adder : Function2[Int,Int,Int] = new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  val adder2 : ((Int,Int) => Int) = _ + _

  //ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1) Take 2 Strings and concatenate them
  2) MyList transform myPredicate and MyTransformer into Function Types
  3) Define a function that takes an Int and return another Function that takes and Int and returns an Int
    Whats the type of the function?
   */

  //1)
  val stringAdder : (String,String) => String = _ + _
  println(stringAdder("Hello"," World"))
  //3) High order function, or Function1[Int,Function1[Int,Int]]
  val curryAdder : Int => Int => Int = a => b => a + b
  val adder3 = curryAdder(3)
  val result = adder3(1)
  println(result)
  println(curryAdder(3)(4))

  trait MyFunction[A,B] {
    def apply(elem: A): B
  }
}
