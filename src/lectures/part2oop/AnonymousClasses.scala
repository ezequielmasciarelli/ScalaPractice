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

  val eze = new Person("Eze") {
    override def sayHi: Unit = println(s"Hola te redefini sayHi")
  }


}
