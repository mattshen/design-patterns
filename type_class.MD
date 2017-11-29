
```scala
//type class
trait Show[A] {
  def show(a: A): String
}

object Show {
  def apply[A](implicit sh: Show[A]): Show[A] = sh

  object ops {
    def show[A: Show](a: A) = Show[A].show(a)
    //use implicit class for implicit conversion
    implicit class ShowOps[A: Show](a: A) {
      def show = Show[A].show(a)
    }
  }

  // type class instances
  implicit val intCanShow: Show[Int] =
    (int: Int) => s"int $int"

  implicit val stringCanShow: Show[String] =
    (str: String) => s"string $str"

}

import Show.ops._
42.show
"42".show
```
