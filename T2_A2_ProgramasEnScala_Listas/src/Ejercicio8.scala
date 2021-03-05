import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejercicio8 {
  def verificarCapicuo(num:Int) : Boolean = {
    var mitad1 = ""
    var mitad2 = ""

    if (num.toString.length%2 == 0){
      mitad1 = num.toString.substring(0, num.toString.length/2)
      mitad2 = num.toString.substring(num.toString.length/2, num.toString.length)
    } else {
      mitad1 = num.toString.substring(0, num.toString.length/2)
      mitad2 = num.toString.substring((num.toString.length/2)+1, num.toString.length)
    }

    if (mitad1.equals(mitad2.reverse)) true else false
  }

  def obtenerCapicuos(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val listaCapicuos = new ListBuffer[Int]()

    for (e <- lista.indices) if(verificarCapicuo(lista(e))) listaCapicuos += lista(e)

    listaCapicuos
  }

  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    println("¿Cuantos números deseas ingresar a la lista?")
    val n = readInt()

    for (i <- 1 to n) {
      println("Ingrese el número " + i + ": ")
      numeros += readInt()
    }
    

    println("Numeros de la Lista original.")
    println(numeros)
    val capicuos = obtenerCapicuos(numeros)

    if(capicuos.isEmpty) println("No se encontraron capicuos.")
    else {
      println("Numeros de la lista de capicuos.")
      println(capicuos)
    }
  }
}