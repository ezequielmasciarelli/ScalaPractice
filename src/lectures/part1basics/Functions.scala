package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int) : String = {
    a + " " + b
  }


  def aFun2(a:String,b:Int) : String = a + " " + b

  def aFun3(a:String,b:Int) = a + " " + b
  //THE FUNCTION TYPES CAN BE INFER


  //aFun2 es una expresion que se asigna con el operador =
  // Puede recibir un bloque o simplemente una expresion inline


  println(aFunction("hello",2))

  def aParameterLessFun() : Int = 42

  println(aParameterLessFun())
  println(aParameterLessFun) //De las dos maneras se invoca la funcion

  def aRepeatFun(a:String,n:Int):String = { //Como evitar un bucle de la manera funcional
    if(n == 1) a
    else a + aRepeatFun(a,n-1)
  }
  //THE RETURN TYPES IN RECURSIVE FUNCTIONS CAN'T BE INFER
  //AS A GOOD PRACTICE ALWAYS SET THE RETURN TYPE OF FUNCTIONS

  println(aRepeatFun("Hello",3))
  //WHEN YOU NEED LOOPS YOU USE RECURSION.
  //DO NOT USE IMPERATIVE CODE IN A SCALA SYNTAX



  def aFunctionWithSideEffects(a:String) : Unit = {
    println(a)
  }
  //WE USE UNIT AS RETURN TYPE IF WE WANT TO WRITE A FUNCTION WITH SIDE EFFECTS

  def aBigFun(a:Int) : Int = {
    def aSmallFun(a:Int,b:Int) : Int = a + b
    aSmallFun(a,5)
  }

  println(aBigFun(1))

  def aGreetingFun(name:String,age:Int): String = s"Hi, my name is $name and I am $age years old"
  def aFactorial(n:Int):Int = if(n == 1) n else aFactorial(n-1) * n
  println(aGreetingFun("Eze",23))
  println(aFactorial(4))

  def aFibonacciFun(n:Int) : Int = {
    if(n == 1 || n == 2) 1 else aFibonacciFun(n-1) + aFibonacciFun(n-2)
  }

  println(aFibonacciFun(3)) //SHOULD BE 2
  println(aFibonacciFun(4)) //SHOULD BE 3
  println(aFibonacciFun(5)) //SHOULD BE 5

  def isPrime(n:Int) : Boolean = {
    def isPrimeUntil(t:Int):Boolean =
      if(t == 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n/2)
  }

  println(isPrime(13))
  println(isPrime(14))

}
