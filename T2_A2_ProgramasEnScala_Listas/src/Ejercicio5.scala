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
  
  def eliminarRep(palabra: String, lista: => ListBuffer[String]) : ListBuffer[String] = {
    var sum = 0
    for(i <- 0 until lista.size){
      if(lista(i) == palabra){
        sum += 1
      }
    }
    if(sum >= 2){
      for(e <- 0 until sum-1){
        lista -= palabra
      }
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
  
  def listasSinRep(lista1: => ListBuffer[String], lista2: => ListBuffer[String]) : Unit ={
    var listax1 = lista1
    var listax2 = lista2
    var listaN1 = eliminarPalabras(listax1, lista2)
    var listaN2 = eliminarPalabras(listax2, lista1)
    var palabrasUniSinRep = ListBuffer[String]()
    palabrasUniSinRep = listaN1
    for(e <- 0 until listaN2.size){
      palabrasUniSinRep += listaN2(e)
    }
    println(palabrasUniSinRep)
  }
  
  def main(args: Array[String]): Unit = {
    var listaPalabras1 = crearLista(1)
    var listaPalabras2 = crearLista(2) 
    
    var list1=listaPalabras1
    println(listaPalabras1.size)
    for(i <- 0 until list1.size-1){
      print(i)
      list1=eliminarRep(listaPalabras1(i),listaPalabras1)
    }
    println(list1)
    var list=listaPalabras2
    for(i <- 0 until listaPalabras2.size-1){
      list=eliminarRep(listaPalabras2(i),listaPalabras2)
    }
    println(list)
    
    println("Lista1: " + listaPalabras1)
    println("Lista2: " + listaPalabras2)
 
    
    
    var lista1 = new ListBuffer[String]()
    var lista2 = new ListBuffer[String]()
    lista1=listaPalabras1.clone()
    lista2 = listaPalabras2.clone()
    println()
    
    println("Las listas resultantes son: ")
    println("1) Lista de palabras que aparecen en las dos listas: " + unionListas(listaPalabras1, listaPalabras2))
    println("2) Lista de palabras que aparecen en la primera lista, pero no en la segunda: " + eliminarPalabras(listaPalabras1, lista2))
    
    println("3) Lista de palabras que aparecen en la segunda lista, pero no en la primera: " + eliminarPalabras(lista2, lista1))
    println("4) Lista de palabras que aparecen en ambas listas sin repeticiones: " + listasSinRep(listaPalabras1, listaPalabras2))
  }
}
