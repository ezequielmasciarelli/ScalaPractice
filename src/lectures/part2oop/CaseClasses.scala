package lectures.part2oop

object CaseClasses extends App {
  //tienen equals,hashcode,toString por defecto
  case class Person(name:String, age:Int)

  //all parameters are fileds
  val eze = new Person("Eze",10)
  eze.name
  println(eze.toString)
  println(eze) //invoca al toString

  //Equals y hashcode implementados
  val eze2 = new Person("Eze",10)
  println(eze == eze2)

  //Copy copado
  val eze3 = eze.copy(age = 20)

  //tienen companions
  val person = Person
  val jorge = person.apply("Jorge",40)
  val jorge2 = Person("Jorge",40)

  //Serializables,can send CClases over HTTP, Akka, messages are case classes

  //Have extractor patterns, can be used in pattern match

  //Hay case objects tambien!
  case object UnitedKingdom {
    def name = "Soy de Argentina"
  }
}
