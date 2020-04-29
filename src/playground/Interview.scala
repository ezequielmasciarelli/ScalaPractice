package playground

object Interview extends App {
  def solution(a: Array[Int]): Int = {
    val max = a.max
    if(max < 0) 1
    else {
      val diff = 1.to(max).toList.diff(a)
      if(diff.isEmpty) max + 1
      else {
        val num = diff.min
        if(num < 0)
          1
        else
          num
      }
    }
  }

  val num = solution(Array(1,3,6,4,1,2))
  println(num)
  val num2 = solution(Array(1,2,3))
  println(num2)
  val num3 = solution(Array(-1,-3))
  println(num3)
}
