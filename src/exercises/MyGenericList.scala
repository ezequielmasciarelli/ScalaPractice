package exercises

/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new List with element added
  toString => a string representation of the list
 */

abstract class MyGenericList[+A] {
  def head:A
  def tail:MyGenericList[A]
  def isEmpty:Boolean
  def add[B >: A](n:B):MyGenericList[B]
  def printElements : String
  override def toString: String = s"[ $printElements ]"
}

object EmptyGeneric extends MyGenericList[Nothing] {
  def head:Nothing = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def printElements: String = ""
  def tail:MyGenericList[Nothing] = throw new NoSuchElementException
  def add[B >: Nothing](n: B) : MyGenericList[B] = new ConsGeneric(n,EmptyGeneric)
  //Si llega un elemento de tipo superclase de Nothing, retorno una lista de tipo B (siempre va a retornar una lista de tipo B porque nothing esta abajo de toda la gerarquia)
}

class ConsGeneric[+A](h:A,t:MyGenericList[A]) extends MyGenericList[A] {
  def head: A = h
  def tail:MyGenericList[A] = t
  def isEmpty:Boolean = false
  def add[B >: A](n:B):MyGenericList[B] = new ConsGeneric(n,this)
  def printElements: String =
    if(this.isEmpty) ""
    else s"$h ${t.printElements}"

}

object List2 extends App {
  val list = EmptyGeneric add 1 add 3  add 4 add 4 add 5
  val list2 = EmptyGeneric add "hello" add "world"
  println(list toString)
  println(list2 toString)
}