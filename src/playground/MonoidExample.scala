package playground

object MonoidExample extends App {

  trait Monoid[T] {
    def plus(a1: T, a2: T) : T
    def zero: T
    def foldLeft: List[T] => T = _.foldLeft(zero){ plus }
  }

  object IntMonoid extends Monoid[Int] {
    override def plus(a1: Int, a2: Int): Int = a1 + a2
    override def zero: Int = 0
  }

  object StringMonoid extends Monoid[String] {
    override def plus(a1: String, a2: String): String = s"$a1$a2"
    override def zero: String = ""
  }

  object DoubleMonoid extends Monoid[Double] {
    override def plus(a1: Double, a2: Double): Double = a1 + a2
    override def zero: Double = 0.0
  }

  implicit val intMonoid: IntMonoid.type = IntMonoid
  implicit val stringMonoid: StringMonoid.type = StringMonoid
  implicit val dobuleMonoid: DoubleMonoid.type = DoubleMonoid

  // With explicit Monoid
  def sum5[A](a:List[A],m: Monoid[A]): A = a.foldLeft(m.zero) { m.plus }

  // With implicit Monoid
  def sum4[A](a:List[A])(implicit m: Monoid[A]): A = a.foldLeft(m.zero) { m.plus }

  // With implicit Monoid using type bounds (syntactic sugar)
  def sum3[A : Monoid](a:List[A]): A = {
    val m = implicitly[Monoid[A]]
    a.foldLeft(m.zero) { m.plus }
  }

  // Using default Fold left of list
  def sum2[A : Monoid](a:List[A]): A = {
    val m = implicitly[Monoid[A]]
    a.foldLeft(m.zero) { m.plus }
  }

  // The final version using my own definition of foldLeft
  def sum[A : Monoid](list:List[A]): A = implicitly[Monoid[A]].foldLeft(list)


  println(sum(List(1,2,3)))
  println(sum(List("a","b","c")))
  println(sum(List(1.2,2.3,3.5)))

  case class Perro(nombre: String)
  case class Persona(nombre: String)

  val l1 = List(Persona("Eze"),Persona("Andy"))
  val l2 = List(Perro("Chiguagua"),Perro("Andy"))

  val names = for {
    p1 <- l1
    p2 <- l2
    if p1.nombre == p2.nombre
  } yield p1.nombre

  println(names)

}
