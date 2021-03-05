import scala.collection.mutable.ListBuffer
import scala.io.StdIn._


object Ejercicio6 {
  def listaNumeros(lista: ListBuffer[Int]) : Unit = {
    println("¿Cuantos numeros desea agregar? ")
    var n = readInt()
    for(i <- 1 to n){
      println("Ingrese el numero " + i + ": ")
      lista += readInt()
    }
  }
  
  def mostrarNumeros(lista: ListBuffer[Int]) : Unit = {
    print("[")
    for(e <- lista.indices){
      if(e == lista.length-1){
        print(lista(e))
      }else{
        print(lista(e) + ", ")
      }
    }
    println(" ]")
  }
  
  def sumaAcumulada(lista: ListBuffer[Int]) : ListBuffer[Int] = {
    var suma = new ListBuffer[Int]()
    
    for (e <- lista.indices) if(e == 0) suma += lista(e) else suma += suma(e-1) + lista(e)
    
    suma
  }
  
  def main(args: Array[String]): Unit = {
    var numeros = new ListBuffer[Int]()
     listaNumeros(numeros)
    
    println("La lista de la suma es: " + sumaAcumulada(numeros))
  }
  
}