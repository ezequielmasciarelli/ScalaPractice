package playground
import scala.annotation.tailrec
import scala.collection.mutable

object OddOccurrences extends App {

  def solution1(a: Array[Int]): Int = {
    //Works but inefficient
    a.groupBy(identity).find(_._2.length == 1).head._1
  }

  @scala.annotation.tailrec
  def findValue(a: Array[Int], i: Int): Int = {
    val current = a(i)
    val next = a(i+2)
    if(current != next) next
    else findValue(a,i+1)
  }

  def solution(a: Array[Int]): Int = {
    findValue(a,0)
  }

  println(solution(Array(1,2,1,2,6,8,6,8,6,8)) == 5)

}
