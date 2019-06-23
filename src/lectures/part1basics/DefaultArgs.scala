package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  def factorial(n:Int):Int = {
    @tailrec
    def tailRecFactorial(act:Int,acc:Int):Int =
      if(act==1) acc
      else tailRecFactorial(act-1, acc * act)
    tailRecFactorial(n,1)
  }
  println(factorial(400000000))

  @tailrec
  def simpleTailRecFactorial(act:Int,acc:Int = 1):Int = //I CAN SET THE DEFAULT ACCUMULATOR VALUE TO 1
    if(act==1) acc
    else simpleTailRecFactorial(act-1, acc * act)

  println(simpleTailRecFactorial(5))
  println(simpleTailRecFactorial(act = 5))
  println(simpleTailRecFactorial(5,2))


}
