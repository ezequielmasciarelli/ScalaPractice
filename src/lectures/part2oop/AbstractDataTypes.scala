package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal{
    val creatureType:String
    def eat:Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat: Unit = println("Guau")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlod
  class Crocodile extends Animal with Carnivore with ColdBlod {
    override val creatureType: String = "Croc"

    override def eat: Unit = println("Guau Guau")

    override def eat(animal: Animal): Unit = println(s"Im a $creatureType y me como al ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //Trait vs Abstract Class
  //Las dos pueden tener abstract and non abstract members (concretos)
  //Diferencias
  //1 - traits do not have constructor parameters
  //2 - only can extend one class, but multiple traits can be used
  //3 - traits = behavior, abstract class = "thing"

}
