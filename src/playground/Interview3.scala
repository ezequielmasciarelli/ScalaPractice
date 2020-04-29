package playground

object Interview3 extends App {

  @scala.annotation.tailrec
  def getIdenticalPairs(myPos: Int, value: Int, a: Array[Int], acc: List[(Int,Int)], actualPos: Int,lastPos: Int): List[(Int,Int)] = {
    val act = a.indexOf(value, actualPos + 1)
    if(act == -1 && a.indexOf(value, lastPos + 1) == -1) acc
    else if(act == -1 && a.indexOf(value, lastPos + 1) != -1) {
      val nextPos = a.indexOf(value, lastPos + 1)
      getIdenticalPairs(myPos,value, a, acc, nextPos, nextPos)
    }
    else {
      getIdenticalPairs(myPos,value, a, (myPos,act) :: acc, act,lastPos)
    }

  }

  def solution(a: Array[Int]): Int = {
    val uniqueValues = a.distinct
    val tuples =uniqueValues.flatMap(value => {
      val myPos = a.indexOf(value)
      getIdenticalPairs(myPos, value, a, List.empty, myPos,myPos)
    })
    tuples.length
  }

  solution(Array(3,5,6,3,3,5))

}
