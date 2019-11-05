package lectures.part2oop

import scala.annotation.tailrec

object Exceptions extends App {

  //1. Throw Exceptions
  val x: String = null
  //println(x.length) NPE

  //val aExplosiveValue : Nothing = throw new NullPointerException //Nothing is subclass of anything
  //val aExplosiveValue2 : String = throw new NullPointerException

  //throwable classes extend the throwable class
  //Exception and Error are the mayor throwable subtypes

  //2. Catch Exceptions

  def getInt(withException: Boolean) : Int =
    if(withException) throw new RuntimeException("NO int for u")
    else 42

  //CTRL + Q Muestra el tipo, si pongo todos int en los try y catch retorna el tipo INT, si pongo el catch
  // Unit retorna AnyVal (Unificacion entre Int y AnyVal)
  val potentialExplosion = try {
    getInt(false)
  }
  catch {
    case e: NullPointerException => println("Atrape una RuntimeException"); 23
  } finally {
    //Code executed no matter what! Even if doesn't catch anything
    //finnaly no influye el tipo final
    //Solo usar finally para side effects
    println("finnaly")
  }

  //3 Define my own exceptions
  class MyException extends Exception
  val exception = new MyException
  //throw exception

  /*
  1. Crash program OutOfMemoryError
  2. Crash with SOError
  3. PocketCalculator
    - add(x,y)
    - subtract(x,y)
    - divide(x,y)
    Throw
      - OverFlowException if add(x,y) exceds Int.MAX_VALUE
      - UnderFlowException if subtract(x,y) exceeds Int.MIN_VALUE
      - MathCalculationException for division by 0
   */


  //1. OOM
  //val arr = Array.ofDim(Int.MaxValue)

  //2. Stack Overflow
  def infinite:Int = 1 + infinite
  //infinite

  class SOError extends Exception
  class OverFlowException extends Exception
  class UnderFlowException extends Exception
  class MathCalculationException extends Exception

  object PocketCalculator {
    def add(x:Int,y:Int): Int ={
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }
  }
    def subtract(x:Int,y:Int): Int = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new OverFlowException
      if(x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

  def divide(x:Int,y:Int): Int =
      if(y == 0) throw new MathCalculationException
      else x/y
}
