package lectures.part2oop

import java.util.Date

import lectures.part2oop.OOBasics.Writer
//Notar este import, trae las dos cosas
import playground.{Cinderella, PrinceCharming}
//Podemos poner "Aliases" con la arrow
//import playground.{Cinderella => Princess, PrinceCharming}
//Tambien, si la lista se hace grande, podemos traer everything con esto:
//import playground._ trae toodo
import java.sql.{Date => SqlDate}

object PackaginAndImports extends App {
  val writer = new lectures.part2oop.OOBasics.Writer("Ezequiel","Masciarelli",24)
  val writter2 = new Writer("Ezequiel","Masciarelli",24)
  val princess = new Cinderella


  //package object -> Tienen comportamiento universal para all the paquete

  //Vienen del package object definido
  sayHello()
  println(SPEED_OF_LIGHT)

  val prince = new PrinceCharming

  val date = new Date
  val date2 = new java.sql.Date(22,12,2)
  val date3 = new SqlDate(22,12,2)

  //Default imports (implicitos)
  //java.lang - String, Object, Exception
  //scala - Int, Nothing, Function
  //scala.Predef - println, ???

}
