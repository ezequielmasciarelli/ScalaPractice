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

  //High order functions
  def filter(myPredicate: A => Boolean):MyGenericList[A]
  def map[B](myTransformer: A => B):MyGenericList[B]
  def flatMap[B](myTransformer: A => MyGenericList[B]):MyGenericList[B]

  //Concatenacion de listas
  def ++[B >: A](list:MyGenericList[B]):MyGenericList[B]
  override def toString: String = s"[ $printElements ]"
}

object EmptyGeneric extends MyGenericList[Nothing] {
  def head:Nothing = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def printElements: String = ""
  def tail:MyGenericList[Nothing] = throw new NoSuchElementException
  def add[B >: Nothing](n: B) : MyGenericList[B] = new ConsGeneric(n,EmptyGeneric)
  override def filter(myPredicate: Nothing => Boolean): MyGenericList[Nothing] = EmptyGeneric
  override def map[B](myTransformer: Nothing => B): MyGenericList[B] = EmptyGeneric
  override def flatMap[B](myTransformer: Nothing => MyGenericList[B]): MyGenericList[B] = EmptyGeneric
  override def ++[B >: Nothing](list: MyGenericList[B]): MyGenericList[B] = list

  //Si llega un elemento de tipo superclase de Nothing, retorno una lista de tipo B (siempre va a retornar una lista de tipo B porque nothing esta abajo de toda la gerarquia)
}

class ConsGeneric[+A](h:A,t:MyGenericList[A]) extends MyGenericList[A] {
  def head: A = h
  def tail:MyGenericList[A] = t
  def isEmpty:Boolean = false
  def add[B >: A](n:B):MyGenericList[B] = new ConsGeneric(n,this)

  override def filter(myPredicate: A => Boolean): MyGenericList[A] =
    if(myPredicate(h)) new ConsGeneric(h,t.filter(myPredicate))
    else t.filter(myPredicate)

  /*[1,2].map(n*2)
    = new Cons(2,[1].map(n*2))
    = new Cons(2, new Cons(2,Empty.map(n*2))
    = new Cons(2, new Cons(4, new Cons(Empty)))
   */
  override def map[B](myTransformer: A => B): MyGenericList[B] =
    new ConsGeneric(myTransformer(h),t.map(myTransformer))

  /*
    [1,2].flatMap(n => [n,n+1])
    = [1,2] ++ [2].flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n,n+1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]

   */
  override def flatMap[B](myTransformer: A => MyGenericList[B]): MyGenericList[B] =
    myTransformer(h) ++ t.flatMap(myTransformer)

  /*[1,2] ++ [3,4,5]
    = new Cons(1,[2] ++ [3,4,5]
    = new Cons(1, new Cons(2,Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2, [3,4,5]) // Nota [3,4,5] == new Cons(3, new Cons(4, new Cons(5)))
   */
  override def ++[B >: A](list: MyGenericList[B]): MyGenericList[B] =
    new ConsGeneric(h,t ++ list)

  def printElements: String =
    if(this.isEmpty) ""
    else s"$h ${t.printElements}"


}

/*  Como Scala tiene funciones que hacen esto, no hace falta definirlas
    //EJERCICIO MAP FILTER
    trait MyPredicate[-T] { // T => Boolean
      def test(a:T):Boolean
    }
    trait MyTransformer[-A,B] { // A => B
      def transform(a:A):B
    }
 */


object List2 extends App {
  val list = EmptyGeneric add 1 add 3  add 4 add 4 add 5
  val list2 = EmptyGeneric add "hello" add "world"
  println(list toString)
  println(list2 toString)

  //Ejercicio MAP FILTER
  val evenPredicate = new Function1[Int,Boolean] {
    override def apply(a: Int): Boolean = a % 2 == 0
  }
  val stringToIntTransformer = new Function1[String,Int] {
    override def apply(a: String): Int = a toInt
  }

  //Se puede poner o se saca del myTransformer el [Type] list.map[Int](transformer) == list.map(transformer)
  val listaMultiplicada = list.map(new Function1[Int,Int] {
    override def apply(a: Int): Int = a * 2
  })

  println(listaMultiplicada)

  val listaDePares = list.filter(evenPredicate)
  println(listaDePares)

  val anotherList = new ConsGeneric(1,new ConsGeneric(4,new ConsGeneric(7,EmptyGeneric)))
  val listSumadas = list ++ anotherList
  println(listSumadas)

  println(listSumadas.flatMap(new Function1[Int,MyGenericList[Int]] {
    override def apply(a: Int): MyGenericList[Int] = new ConsGeneric(a,new ConsGeneric(a+1,EmptyGeneric))
  }))

}