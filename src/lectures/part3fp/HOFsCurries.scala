package lectures.part3fp

import scala.annotation.tailrec

object HOFsCurries extends App {
  //define a function that takes a function, a number and the result is the function evaluated n times
  //nTimes(f,n,x) => nTimes(f,3,x) == f(x) 3 times

  @tailrec
  def nTimes(f: Int => Int, n:Int, x: Int):Int =
    if(n <= 0) x
    else nTimes(f,n-1,f(x))

  val plusOne = (x: Int) => x + 1
  val result = nTimes(plusOne,10,1)
  println(result)

  //creates a function that is evaluated n times
  def nTimesBetter(f: Int => Int, n:Int) : (Int => Int) = x => {
    if(n <= 0) x
    else nTimesBetter(f,n-1)(f(x))
  }

  def nTimesBetter2(f: Int => Int, n:Int) : (Int => Int) =
    if(n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter2(f,n-1)(f(x))

  val plus10 = nTimesBetter(plusOne,10)
  val plus10two = nTimesBetter2(plusOne,10)
  println(plus10(1))
  println(plus10two(1))

  val curryAdder : Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = curryAdder(3)

  def curryFormat(c: String)(x:Double): String = c.format(x)
  val standardFormat: Double => String = curryFormat("%4.2f")
  val preciseFormat: Double => String = curryFormat("%10.8f")
  println(preciseFormat(Math.PI))
  println(standardFormat(Math.PI))

  /*
  1) Expand MyList add Foreach A => Unit
  [1,2,3].foreach(x => println(x))

  2) sort function ((A,A) => Int) => MyList
  [1,2,3].sort((x,y) => y < x) [3,2,1]

  3) zipWith (list, (A,A) => B) MyList[B]
  [1,2,3].zipWith([4,5,6], x*y) => [1*4,2*5,3*6] => [4,8,18]
  4) fold(startValue)(function) => a value
  [1,2,3].fold(0)(x+y) => 6

  5) toCurry(f: (Int,Int) => Int) : (Int => Int => Int)
  6) fromCurry(f: (Int => Int => Int)) : (Int,Int) => Int
  7) compose(f,g) => x => f(g(x))
  8) andThen(f,g) => x => g(f(x))
   */



}
