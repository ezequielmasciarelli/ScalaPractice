package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat:Unit
  }

  //Instancio una clase anonima
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("INSTANCIE UN OBJETO ABSTRACTO :O")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hola, soy $name")
  }

  //Recordar que para instanciarlas es necesario que respete el constructor de arriba
  val eze = new Person("Eze") {
    override def sayHi: Unit = println(s"Hola te redefini sayHi")
  }


  /* DEFINIR EN MyGenericList lo siguiente
  1. Generic Trait MyPredicate[T] define un metodo que verifica si T cumple o no cumple la condicion
  2. Generic Trait MyTransformer convierte algo de tipo A a tipo B
  3. MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B]) => MyList[B]
      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String,Int]

      [1,2,3].map(n*2) = [2,4,6]
      [1,2,3,4].filter(n%2) = [2,4]
      [1,2,3].flatMap(n => [n,n+1]) => [1,2,2,3,3,4]

   */

  //ASUMIR EL MENOS, DEFINIR COMO CONTRAVARIANTE T y A, (no se explica todavia, es avanzado a esta altura)

  trait MyPredicate[-T] {
    def test(a:T):Boolean
  }
  trait MyTransformer[-A,B] {
    def transform(a:A):B
  }

  //Los implemento con clases anonimas, pero se puede hacer concreta tambien
  val evenPredicate = new MyPredicate[Int] {
    override def test(a: Int): Boolean = a % 2 == 0
  }
  //Es equivalente a
  class isEven extends MyPredicate[Int] {
    override def test(a: Int): Boolean = a % 2 == 0
  }

  val stringToIntTransformer = new MyTransformer[String,Int] {
    override def transform(a: String): Int = a toInt
  }




}
