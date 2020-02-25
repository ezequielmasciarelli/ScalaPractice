package lectures

package object part2oop {
  //Solo se puede tener 1 package object por paquete
  //Contiene comportamiento universal para ese paqueta
  def sayHello() : Unit = println("Hello")
  val SPEED_OF_LIGHT = 300000
}
