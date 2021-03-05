import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejercicio9 {
  
  def verificarPrimo(num:Int) : Boolean = {
    var divisores = 0

    for (e <- 1 to num) if (num % e == 0) divisores += 1

    if(divisores == 2) true else false
  }

  def obtenerPrimos(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val listaPrimos = new ListBuffer[Int]()

    for (e <- lista.indices) if(verificarPrimo(lista(e))) listaPrimos += lista(e)

    listaPrimos
  }

  def obtenerSumatoriaYPromedio(lista:ListBuffer[Int]) : Unit = {
    var sumatoria = 0

    for (e <- lista.indices) sumatoria += lista(e)

    println("\nLa sumatoria de los numeros es: " + sumatoria)
    println("\nEl promedio de los numeros es: " + sumatoria.toDouble/lista.length)
  }

  def obtenerFactorial(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val listaFactorial = new ListBuffer[Int]()

    for (e <- lista.indices){
      var factorial = 1

      if (lista(e) > 2) for (j <- 2 to lista(e)) factorial *= j
      else factorial = lista(e)

      listaFactorial += factorial
    }

    listaFactorial
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
    val primos = obtenerPrimos(numeros)
println()
    if(primos.isEmpty) println("No se encontraron numeros primos.")
    else {
      println("Numeros de la lista de primos.")
      println(primos)
    }
    obtenerSumatoriaYPromedio(numeros)
    println()
    println("Factoriales de la lista de numeros.")
    println(obtenerFactorial(numeros))
  }
  
}