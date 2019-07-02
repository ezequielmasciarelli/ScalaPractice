package lectures.part2oop

object OOBasics extends App {

  class Person(name:String,val age:Int = 0) { //age has a default parammeter and is a field
    //in every instantiation this whole block is executed
    //class body
    val x = 2
    println(x + 1)
    //the result of the whole expression is ignored { }

    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")

    //only use this if necessary greet is a method because is inside a class
    def greet(): Unit = println(s"Hi, I am $name") //OVERLOADING METHOD

    def this(name: String) = this(name, 0)

    def this() = this("John Doe")
  }


  val person = new Person("Ezequiel",23)
  println(person)
  println(person.age)
  println(person.x)
  //println(person.age) AGE IS CLASS PARAMETER BUT NOT MEMBER
  //CLASS PARAMETERS ARE NOT FILEDS (CANNOT BE ACCESED)
  //TO CONVERT TO FIELD YOU HAVE TO ADD the keyworkd val

  person.greet("Jorge")
  person.greet()

  //EJ 1, Novel y Writer
  class Writer(val firstname:String,val surname:String,val year:Int) {
    def fullname = s"$firstname $surname"
  }

  class Novel(name:String,release:Int,author:Writer) {
    def authorAge: Int = release - author.year

    def isWrittenBy(author: Writer) = author.fullname == this.author.fullname

    def copy(newYear: Int) = new Novel(name, newYear, author)
  }

  //EJ 2 Counter class
  class Counter(val num:Int = 0) {
    def inc = new Counter(num + 1) //Immutability, instances cannot be muted
    def dec = new Counter(num - 1)

    def inc(n:Int): Counter = {
      if(n<=0) this
      else inc.inc(n-1)
    }

    def dec(n:Int): Counter = {
      if(n<=0) this
      else dec.dec(n-1)
    }
  }


  val counter = new Counter
  counter.inc.inc.inc
  val newCounter: Counter = counter.inc
  val newCounter2: Counter = counter.inc(20)
  val newCounter3: Counter = counter.dec(20)


  println(s"the new counter value is ${newCounter2.num}")
  println(s"the new counter value is ${newCounter3.num}")


}







