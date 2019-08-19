package lectures.part2oop

object Generics extends App {

  class MyMap[Key,Value]
  trait MyTrait[A]

  class MyList[+A]{
    //use type A
    def add[B >: A](element :B) : MyList[B] = ???
    /*
    A = CAT
    B = ANIMAL
     */
  }

  object MyList {
    def empty[A]:MyList[A] = ???
  }

  val listInt = new MyList[Int]
  val listString = new MyList[String]

  val emptyListInt = MyList.empty[Int]

  //Variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //Does list of cat extends list of animal?
  // 1. If yes COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) ??? Hard Question
  //La respuesta es que si le agrego a una lista de Cats un Dog, la lista se transformara en algo mas generico
  //En este caso en una lista de Animales

  // 2. NO, INVARIANCE
  class InvariantList[A]
  //val invariantList: InvariantList[Animal] = new InvariantList[Cat] ESTO ROMPE
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  //3. CONTRAVARIANCE
  class Trainer[-A]
  val trainer:Trainer[Cat] = new Trainer[Animal]

  //BOUND types (restricciones de tipos)

  //Acepts subtypes of Animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  //val cage2 = new Cage(new Car) //ESTO NO ANDA

  class Cage2[A >: Animal](animal: A) //Only acepts supertypes of animal

  //expand MyList to be generic

}
