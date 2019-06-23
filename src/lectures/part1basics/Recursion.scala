package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def aFactorial(n:Int):Int = {
    if(n == 1) n else {
      println(s"Computing factorial of $n - I first need factorial of ${n-1}")
      val result = aFactorial(n-1) * n
      println(s"Computed factorial of $n")
      result
    }
  }

  println(aFactorial(10))
  //println(aFactorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression on each path

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
   */

  println(anotherFactorial(20000))

  //IN TAILREC, RECURSIVE CALL MUST BE THE LAST EXPRESSION OF EACH PATH
  //WHEN WE NEED LOOPS, WE USE TAILREC

  /*
    1. Concatenate String N Times
    2. IsPrime tail Recursive
    3. Fibonacci tail Recursive
   */

  //NOTE ANY FUNCTION CAN BE TRANSFORMED TO AN TAIL RECURSION,USE ACCUMULATORS

  @tailrec
  def stringConcat(a: String,n:Int):String = if(n==1) a else stringConcat(a,n-1)

  def isPrime(n:BigInt):Boolean = {
    @tailrec
    def isPrimeUntil(t:BigInt):Boolean = {
      //if(t == 1) true else isPrimeUntil(t-1) && n % 2 != 0 ESTO NO ANDA Porque el llamado no esta en la cola
      if(t == 1) true else n % 2 != 0 && isPrimeUntil(t-1) //ESTO ANDA Porque el llamado recursivo esta en la cola
    }
    isPrimeUntil(n)
  }
  println(isPrime(1000000000))

  def fibonacci(n:Int) : Int = {
    @tailrec
    def fiboTailRec(i:Int,last:Int,lastlast:Int):Int = {
      if(i==n) last
      else fiboTailRec(i+1,last + lastlast,last)
    }
    fiboTailRec(2,1,1)
  }

  def sumNElements(n:Int) : Int = {
    @tailrec
    def sumTailRec(n:Int,actual:Int,acc:Int):Int =
      if(actual==n) acc
      else sumTailRec(n,actual+1,acc+actual)
    sumTailRec(n,1,0)
  }
  println(sumNElements(10))

}
