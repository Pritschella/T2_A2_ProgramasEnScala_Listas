import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

/*
 * Escriba un programa que permita crear una lista de palabras y que, a continuación, pida una
		palabra y elimine esa palabra de la lista.
 */

object Ejercicio3 {
  def crearLista() : ListBuffer[String] = {
    var listaPalabras = new ListBuffer[String]()
    println("¿Cuantas palabras desea ingresar  a la lista?")
    var n = readInt()
    for(i <- 0 until  n){
      println("Ingresa la palabra " + (i + 1) + ":")
      listaPalabras += readLine()
    }
    listaPalabras
  }
  
  def pedirPalabra() : String = {
    println("Ingrese la palabra a eliminar: ")
    val palabra = readLine()
    palabra
  }
  
  def eliminarPalabra(palabra: String, lista: => ListBuffer[String]) : ListBuffer[String] = {
    var sum = 0
    for(i <- 0 until lista.size){
      if(lista(i) == palabra){
        sum += 1
      }
    }
    for(e <- 0 until sum){
      lista -= palabra
    }
    lista
  }
  
  
  def main(args: Array[String]): Unit = {
    var listaPalabras = crearLista()
    println("\nLa lista es: " + listaPalabras)
    
    listaPalabras = eliminarPalabra(pedirPalabra(), listaPalabras)
    println("\nLa lista modificada es: " + listaPalabras)
  }
}