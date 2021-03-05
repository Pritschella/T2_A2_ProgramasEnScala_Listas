import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejercicio10 {
  
  def eliminarRepetidas(lista:ListBuffer[ListBuffer[Int]]) : Unit = {
    for (e <- lista.indices) {
      for (j <- e+1 until lista.size) {
        if(lista(e).head == lista(j).head) {
          lista.remove(j)
          eliminarRepetidas(lista)
          return
        }
      }
    }
  }

  def buscarNumero(lista:ListBuffer[Int], num:Int) : Int = {
    var cantidadCoincidencias = 0

    for (e <- lista) if(e == num) cantidadCoincidencias += 1

    cantidadCoincidencias
  }

  def empaquetarLista(lista:ListBuffer[Int]) : ListBuffer[ListBuffer[Int]] = {
    val listaEmpaquetada = ListBuffer[ListBuffer[Int]]()

    for (e <- lista){
      val paquete = ListBuffer[Int]()
      paquete += e
      paquete += buscarNumero(lista, e)

      listaEmpaquetada += paquete
    }

    eliminarRepetidas(listaEmpaquetada)

    listaEmpaquetada
  }


  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    println("¿Cuantos números deseas ingresar a la lista?")
    val n = readInt()

    for (i <- 1 to n) {
      println("Ingrese el número " + i + ": ")
      numeros += readInt()
    }
    println("")
    println("Numeros de la Lista original.")
    println(numeros)
    println()
    println("Datos de la lista original empaquetados.")
    println(empaquetarLista(numeros))
  }
  
}