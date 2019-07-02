package lectures.part2oop

object Objects extends App {
  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person { //type + its only instance SINGLETON
    //GLOBAL FUNCTIONALITY
    val N_EYES = 2
    def canFly: Boolean = true

    //FACTORY METHODS THAT CREATE INSTANCES
    def from(mother:Person,father:Person) : Person = new Person("Bobbie")

    //NORMALLY FACTORY METHODS ARE CALLED APPLY
    def apply(mother:Person,father:Person) : Person = new Person("Bobbie")

  }
  //A OBJECT WITH ITS CLASS IS CALLED COMPANION PATTERN
  class Person(val name:String="JORGE") {
    //INSTANCE LEVEL FUNCTIONALITY
  }

  println(Person.N_EYES)
  println(Person.canFly)

  val marry2 = Person
  val john2 = Person
  println(marry2 == john2) //THE SAME SINGLETON

  val marry = new Person("Marry")
  val john = new Person("John")
  println(marry2 == john2)//DIFFERENT OBJECTS

  val bobbie = Person.from(marry,john) //USING FROM FACTORY
  val bobbie2 = Person(marry,john) //USING APPLY FACTORY


  //SCALA APPLICATIONS = SCALA OBJECT WITH
  //def main(args: Array[String]):Unit

}
