package playground

object Interview4 extends App {

  def getAreaPairing(numberOfBuildings: Int, a: Array[Int]) : Int = {
    if(numberOfBuildings == 0) a.length * a.max
    else {
      val (group1,group2) = a.splitAt(numberOfBuildings)
      group1.max * group1.length + group2.max * group2.length
    }
  }

  def solution(a: Array[Int]): Int = {
    a.indices.map(numberOfBuildings => {
      val area : Int = getAreaPairing(numberOfBuildings,a)
      area
    }).min
  }

  val result = solution(Array(3,1,4))
  println(result == 10)

}
