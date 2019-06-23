package playground

import scala.annotation.tailrec

object ScalaPlayground extends App {

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
}
