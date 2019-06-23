package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Ezequiel",23)
  println(person)
  println(person.age)
  println(person.x)
  //println(person.age) AGE IS CLASS PARAMETER BUT NOT MEMBER
  //CLASS PARAMETERS ARE NOT FILEDS (CANNOT BE ACCESED)
  //TO CONVERT TO FIELD YOU HAVE TO ADD the keyworkd val

  person.greet("Jorge")
  person.greet()

}

class Person(name:String,val age:Int = 0) { //age has a default parammeter and is a field
  //in every instantiation this whole block is executed
  //class body
  val x = 2
  println(x+1)
  //the result of the whole expression is ignored { }

  def greet(name:String): Unit = println(s"${this.name} says: Hi, $name!")
  //only use this if necessary greet is a method because is inside a class
  def greet(): Unit = println(s"Hi, I am $name") //OVERLOADING METHOD

  def this(name:String) = this(name, 0)
  def this() = this("John Doe")

}