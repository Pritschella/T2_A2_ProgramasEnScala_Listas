import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

/*
 * Escriba un programa que permita crear dos listas de palabras y que, a continuación, escriba las
	siguientes listas (en las que no debe haber repeticiones):
		Lista de palabras que aparecen en las dos listas.
		Lista de palabras que aparecen en la primera lista, pero no en la segunda.
		Lista de palabras que aparecen en la segunda lista, pero no en la primera.
		Lista de palabras que aparecen en ambas listas.
		
Nota: Para evitar las repeticiones, el programa deberá empezar eliminando los elementos
repetidos en cada lista.
 */

object Ejercicio5 {
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
  
  def unionListas(lista1: => ListBuffer[String], lista2: => ListBuffer[String]) : ListBuffer[String] = {
    var palabrasUnidas = lista1
    for(e <- 0 until lista2.size){
      palabrasUnidas += lista2(e)
    }
    palabrasUnidas
  }
  
  def listasSinRep(lista1: => ListBuffer[String], lista2: => ListBuffer[String]) : ListBuffer[String] ={
    var listaN1 = eliminarPalabras(lista1, lista2)
    var listaN2 = eliminarPalabras(lista2, lista1)
    var palabrasUniSinRep = listaN1
    for(e <- 0 until listaN2.size){
      palabrasUniSinRep += listaN2(e)
    }
    palabrasUniSinRep
  }
  
  def main(args: Array[String]): Unit = {
    var listaPalabras1 = crearLista(1)
    var listaPalabras2 = crearLista(2) 
    println("Lista1: " + listaPalabras1)
    println("Lista2: " + listaPalabras2)
 
    println()
    println("Las listas resultantes son: ")
    println("1) Lista de palabras que aparecen en las dos listas: " + unionListas(listaPalabras1, listaPalabras2))
    println("2) Lista de palabras que aparecen en la primera lista, pero no en la segunda: " + eliminarPalabras(listaPalabras1, listaPalabras2))
    println("3) Lista de palabras que aparecen en la segunda lista, pero no en la primera: " + eliminarPalabras(listaPalabras2, listaPalabras1))
    println("4) Lista de palabras que aparecen en ambas listas sin repeticiones: " + listasSinRep(listaPalabras1, listaPalabras2))
  }
}
