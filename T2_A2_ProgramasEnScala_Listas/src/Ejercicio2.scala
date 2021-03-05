import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

/*
 * Escriba un programa que permita crear una lista de palabras y que, a continuación, pida dos
		palabras y sustituya la primera por la segunda en la lista.
 */

object Ejercicio2 {
  
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
    println("Ingrese la palabra a modificar: ")
    val palabra = readLine()
    palabra
  }
  
  def sustitucionPalabra(palabra1: String, palabra2: String, lista: => ListBuffer[String]) : ListBuffer[String] = {
    var sum = 0
    for(i <- 0 until lista.size){
      if(lista(i) == palabra1){
        sum += 1
        lista.remove(i)
        lista.insert(i, palabra2)
      }
    }
    lista
  }
  
  def main(args: Array[String]): Unit = {
    var listaPalabras = crearLista()
    println("\nLa lista es: " + listaPalabras)
    
    listaPalabras = sustitucionPalabra(pedirPalabra(), pedirPalabra(), listaPalabras)
    println("\nLa lista modificada es: " + listaPalabras)
  }
  
}