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
}
