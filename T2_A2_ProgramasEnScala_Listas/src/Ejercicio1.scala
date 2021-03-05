import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejercicio1 {
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
    println("Ingrese la palabra que desea buscar: ")
    val palabra = readLine()
    palabra
  }
  
  def numRepDePalabras(palabra: String, lista: => ListBuffer[String]) : Unit = {
    var sum = 0
    for(elemento <- lista){
      if(elemento == palabra){
        sum += 1
      }
    }
    println("La palabra " + palabra + " aparece " + sum + " veces en la lista")
  }
  
  def main(args: Array[String]): Unit = {
    var listaPalabras = crearLista()
    println("\nLa lista es: " + listaPalabras)
    numRepDePalabras(pedirPalabra, listaPalabras)
  }
  
}//Object