package structural.flyweight.scala

object FlyweightPattern extends App {

  /*
run as a script using `scala flyweight.scala`
expected output:
  Serving CoffeeFlavour(Espresso) to table 121
  Serving CoffeeFlavour(Cappuccino) to table 121
  Serving CoffeeFlavour(Frappe) to table 552
  Serving CoffeeFlavour(Espresso) to table 96
  Serving CoffeeFlavour(Cappuccino) to table 3
  Serving CoffeeFlavour(Espresso) to table 3
  Serving CoffeeFlavour(Frappe) to table 3
  Serving CoffeeFlavour(Cappuccino) to table 97
  Serving CoffeeFlavour(Frappe) to table 897
  Serving CoffeeFlavour(Espresso) to table 1
  Serving CoffeeFlavour(Frappe) to table 1
  Serving CoffeeFlavour(Cappuccino) to table 2
  total CoffeeFlavour objects made: 3
*/

  class CoffeeFlavour(val name: String) {
    override def toString = s"CoffeeFlavour($name)"
  }

  object CoffeeFlavour {

    import scala.collection.mutable.Map

    private val cache = Map.empty[String, CoffeeFlavour]

    def apply(name: String): CoffeeFlavour =
      cache.getOrElseUpdate(name, new CoffeeFlavour(name))

    def totalCoffeeFlavoursMade = cache.size
  }


  case class Order(tableNumber: Int, flavour: CoffeeFlavour) {

    def serve: Unit =
      println(s"Serving $flavour to table $tableNumber")
  }

  object CoffeeShop {
    var orders = List.empty[Order]

    def takeOrder(flavourName: String, table: Int) {
      val flavour = CoffeeFlavour(flavourName)
      val order = Order(table, flavour)
      orders = order :: orders
    }

    def service: Unit = orders.foreach(_.serve)

    def report =
      s"total CoffeeFlavour objects made: ${CoffeeFlavour.totalCoffeeFlavoursMade}"
  }


  CoffeeShop.takeOrder("Cappuccino", 2)
  CoffeeShop.takeOrder("Frappe", 1)
  CoffeeShop.takeOrder("Espresso", 1)
  CoffeeShop.takeOrder("Frappe", 897)
  CoffeeShop.takeOrder("Cappuccino", 97)
  CoffeeShop.takeOrder("Frappe", 3)
  CoffeeShop.takeOrder("Espresso", 3)
  CoffeeShop.takeOrder("Cappuccino", 3)
  CoffeeShop.takeOrder("Espresso", 96)
  CoffeeShop.takeOrder("Frappe", 552)
  CoffeeShop.takeOrder("Cappuccino", 121)
  CoffeeShop.takeOrder("Espresso", 121)

  CoffeeShop.service
  println(CoffeeShop.report)

  /*
  run as a script using `scala flyweight.scala`
  expected output:
    Serving CoffeeFlavour(Espresso) to table 121
    Serving CoffeeFlavour(Cappuccino) to table 121
    Serving CoffeeFlavour(Frappe) to table 552
    Serving CoffeeFlavour(Espresso) to table 96
    Serving CoffeeFlavour(Cappuccino) to table 3
    Serving CoffeeFlavour(Espresso) to table 3
    Serving CoffeeFlavour(Frappe) to table 3
    Serving CoffeeFlavour(Cappuccino) to table 97
    Serving CoffeeFlavour(Frappe) to table 897
    Serving CoffeeFlavour(Espresso) to table 1
    Serving CoffeeFlavour(Frappe) to table 1
    Serving CoffeeFlavour(Cappuccino) to table 2
    total CoffeeFlavour objects made: 3
  */

  class CoffeeFlavour(val name: String) {
    override def toString = s"CoffeeFlavour($name)"
  }

  object CoffeeFlavour {

    import scala.collection.mutable.Map

    private val cache = Map.empty[String, CoffeeFlavour]

    def apply(name: String): CoffeeFlavour =
      cache.getOrElseUpdate(name, new CoffeeFlavour(name))

    def totalCoffeeFlavoursMade = cache.size
  }


  case class Order(tableNumber: Int, flavour: CoffeeFlavour) {

    def serve: Unit =
      println(s"Serving $flavour to table $tableNumber")
  }

  object CoffeeShop {
    var orders = List.empty[Order]

    def takeOrder(flavourName: String, table: Int) {
      val flavour = CoffeeFlavour(flavourName)
      val order = Order(table, flavour)
      orders = order :: orders
    }

    def service: Unit = orders.foreach(_.serve)

    def report =
      s"total CoffeeFlavour objects made: ${CoffeeFlavour.totalCoffeeFlavoursMade}"
  }


  CoffeeShop.takeOrder("Cappuccino", 2)
  CoffeeShop.takeOrder("Frappe", 1)
  CoffeeShop.takeOrder("Espresso", 1)
  CoffeeShop.takeOrder("Frappe", 897)
  CoffeeShop.takeOrder("Cappuccino", 97)
  CoffeeShop.takeOrder("Frappe", 3)
  CoffeeShop.takeOrder("Espresso", 3)
  CoffeeShop.takeOrder("Cappuccino", 3)
  CoffeeShop.takeOrder("Espresso", 96)
  CoffeeShop.takeOrder("Frappe", 552)
  CoffeeShop.takeOrder("Cappuccino", 121)
  CoffeeShop.takeOrder("Espresso", 121)

  CoffeeShop.service
  println(CoffeeShop.report)

}