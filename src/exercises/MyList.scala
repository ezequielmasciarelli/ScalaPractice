package exercises

/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new List with element added
  toString => a string representation of the list
 */

abstract class MyList {
  def head:Int
  def tail:MyList
  def isEmpty:Boolean
  def add(n:Int):MyList
  def printElements : String
  override def toString: String = s"[ $printElements ]"
}

case object Empty extends MyList {
  def head:Int = throw new NoSuchElementException
  def tail:MyList = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add(n:Int):MyList = new Cons(n,Empty)
  def printElements: String = ""
}

case class Cons(h:Int,t:MyList) extends MyList {
  def head:Int = h
  def tail:MyList = t
  def isEmpty:Boolean = false
  def add(n:Int):MyList = new Cons(n,this)
  def printElements: String =
    if(this.isEmpty) ""
    else s"$h ${t.printElements}"
}
object MyList {
  def apply(seq: Int*): MyList = seq.foldLeft(Empty: MyList){(acc,i) => acc.add(i)}
}

object List extends App {
  val list = Empty add 1 add 2 add 4 add 4 add 5
  val list2 = MyList(1,2,3,4,5,6)
  println(list toString)
  println(list2 toString)
}