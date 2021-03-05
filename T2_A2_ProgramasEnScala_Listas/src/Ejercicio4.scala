import scala.collection.mutable.ListBuffer
import scala.io.StdIn._


/*
 * Escriba un programa que permita crear dos listas de palabras y que, a continuación, elimine de la
		primera lista los nombres de la segunda lista.
 */

object Ejercicio4 {
  def crearLista(lista: Int) : ListBuffer[String] = {
    var listaPalabras = new ListBuffer[String]()
    println("¿Cuantas palabras desea ingresar  a la lista " + lista + "?")
    var n = readInt()
    for(i <- 0 until  n){
      println("Ingresa la palabra " + (i + 1) + ":")
      listaPalabras += readLine()
    }
    listaPalabras
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
  
  def eliminarPalabras(lista1: => ListBuffer[String], lista2: => ListBuffer[String]) : ListBuffer[String] = {
    var lista = lista1
    for(i <- 0 until lista2.size){
      lista = eliminarPalabra(lista2(i), lista1) 
    }
    lista
  }
  
  def main(args: Array[String]): Unit = {
    var listaPalabras1 = crearLista(1)
    var listaPalabras2 = crearLista(2) 
    println("Lista1: " + listaPalabras1)
    println("Lista2: " + listaPalabras2)
    
    println("\nLa lista orgininal es: " + listaPalabras1)
    listaPalabras1 = eliminarPalabras(listaPalabras1, listaPalabras2)
    println("La lista modificada es: " + listaPalabras1)

  }
}