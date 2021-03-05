import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Ejercicio7 {
  
    
  def verificarPalabra(palabra:String) : Boolean = {
    if (palabra.equals(palabra.reverse)) true else false
  }

  def Palindromas(lista:ListBuffer[String]) : ListBuffer[String] = {
    val listaPalindromas = new ListBuffer[String]()
    
    for (e <- lista.indices) if (verificarPalabra(lista(e))) listaPalindromas += lista(e)

    listaPalindromas
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    println("¿Cuantas palabras deseas ingresar a la lista?")
    val cantidadPalabras = readInt()

    for (i <- 1 to cantidadPalabras) {
      println("Ingrese la palabra " + i + ": ")
      palabras += readLine()
    }

    println("Palabras de la Lista original.")
    println(palabras)
    val palindromas = Palindromas(palabras)

    if(palindromas.isEmpty) println("No se encontraron palindromas.")
    else {
      println("Palabras de la lista de palindromas.")
      println(palindromas)
    }
  }
  
}