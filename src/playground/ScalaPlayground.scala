package playground

import scala.annotation.tailrec

object ScalaPlayground extends App {sb

  def sum(x:Int,y:Int) = x + y
  val fun = sum _
  val fun2 = sum(2,_)

  val funPartial = fun(1,_)
  val funPartial2 = fun(2,_)
  val sumar3 = funPartial.compose(funPartial2)
  sumar3(5)
  val result = funPartial(2)
  def plus(a: Int)(b: Int) = a + b
  //val result2 = plus(3)

  def fibonacci(n:Int):Int = {
    if(n==1 || n==2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }

  def fibonacci2(n:Int):Int = {
    @tailrec
    def fibonacciTailRecursive(i:Int,act:Int,ant:Int):Int = {
      if(i == n) act
      else fibonacciTailRecursive(i+1,ant+act,act)
    }

    fibonacciTailRecursive(1,1,0)
  }

  println(fibonacci2(10) == fibonacci(10))

  val nums = Seq(1,2,3) filter isOdd

  println(nums)

  def isOdd(n:Int) = n%2==0

}
