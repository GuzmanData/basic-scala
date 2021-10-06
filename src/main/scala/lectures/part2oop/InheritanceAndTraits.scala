package lectures.part2oop

object InheritanceAndTraits extends App {

  // final class Animal { con el key word final evitamos que esta lase se pueda heredar
  // sealed class Animal { Permite que las clases dentro de este archivo puedan heredar de el, pero solo en este archivo
  class Animal {
    val creatureType = "wild!"

    // protecte permite que este metodo solo pueda ser usado dentro de esta clase o dentro de sus hija
    // protected def eat = println("ñami ñami")

    // Final evitamos que se sobre escriba el metodo  final def eat = println("ñami ñami")
    def eat = println("ñami ñami")
  }


  class Cat extends Animal {
    def crunch = {

      // podemos usar aquí el metodo
      eat
      println("crunch  crunch")
    }
  }

  val cat = new Cat
  // aquí no podemos usaarlo
  cat.crunch



  // Constructor

  class Person(name: String, age: Int) {

    // Constructor auxiliar
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding

  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"

    override def eat = {
      // Llamar al metodo eat de la supr clase
      this.eat
      println("crunch, crunch...")
    }
  }

  val dog = new Dog("domestic")
  dog.eat

  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat
}
