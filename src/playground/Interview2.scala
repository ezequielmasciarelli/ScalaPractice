package playground

import scala.annotation.tailrec

object Interview2 extends App {

  @tailrec
  def getMaxSize(range: List[Int], a: Array[Int], acc: List[Int]): Int = {
    if(acc.distinct.size == 3) acc.size - 1
    else {
      if(range.isEmpty) acc.size
      else {
        val actualPos = range.head
        val actValue = a(actualPos)
        getMaxSize(range.tail, a, actValue :: acc)
      }
    }
  }

  def solution(a: Array[Int]): Int = {
    val lastPos = a.length - 1
    0.to(lastPos)
      .map(pos => {
        val range = pos.to(lastPos).toList
        getMaxSize(range, a, List.empty)
      }).max
  }

  val result = solution(Array(4,2,2,4,2))
  println(result)

  val result2 = solution(Array(1,2,3,2))
  println(result2)

  val result3 = solution(Array(0,5,4,4,5,12))
  println(result3)

}
