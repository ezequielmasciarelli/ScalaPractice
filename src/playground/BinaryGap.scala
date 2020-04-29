package playground

object BinaryGap extends App {

  @scala.annotation.tailrec
  def getGaps(value: Long, max: Int, acc:Int, startCounting: Boolean): Int = {
    val actual = value % 10
    val hasToCount = if(actual == 1 || startCounting) true else false
    val next = value / 10
    val total = if(actual == 0 && hasToCount) acc + 1 else acc
    if((next == 0 || next == 1) && acc == 0) max
    else if(next == 1 && total != 0 && total > max) total
    else {
      if (actual == 0) getGaps(next, max, total,hasToCount)
      else if (actual == 1 && total > max) getGaps(next, total, 0,hasToCount)
      else getGaps(next, max, 0,hasToCount)
    }
  }

  def solution(n: Int): Int = {
    val binaryValue = n.toBinaryString.toLong
    getGaps(binaryValue,0,0,false)
  }

  println(solution(1041) == 5)
  println(solution(32) == 0)
  println(solution(15) == 0)

}
