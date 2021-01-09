import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.collections.ArrayList

fun main(args: Array<String>) {

    var ejemplares: ArrayList<Ejemplar> = arrayListOf()
    var ejemps: ArrayList<Ejemplar> = arrayListOf()

    /*
    Hacemos el registro inicial de un listado de ejemplares
     */
    print("Ingrese la cantidad de ejemplares que desea registrar: ")
    var cantidadEjemplares = readLine()!!.toInt()

    var cont = 1
    while (cantidadEjemplares > 0) {
        println("*** TIPOS DE EJEMPLARES: DVD | BLURAY | VHS ***")
        print("Ingrese el tipo de ejemplar #${cont}: ")
        var tipoEjemplar = readLine()!!

        ejemps = ingresar(tipoEjemplar, ejemplares)
        println()
        cont++
        cantidadEjemplares--
    }
    val videoclub = Videoclub("BlowBuster", ejemps)
    for (ejemplar in ejemps){
        ejemplar.mostrarEjemplar()
    }

    //Iniciamos el menú de opciones
    println("BIENVENIDO A ${videoclub.nombre}")
    do{
        println("""***** MENÚ DE OPCIONES *****
            |1 - Prestar
            |2 - Devolver
            |3 - Controlar ejemplar
            |4 - Mostrar listado de ejemplares
            |5 - Ingresar ejemplares
            |6 - Salir
        """.trimMargin())
        print("OPCIÓN: ")
        var opMenu = readLine()!!.toInt()

        when(opMenu){
            1 -> {
                println("Ingrese el código IMDB del ejemplar a prestar: ")
                val prestamo = readLine()!!.toInt()
                videoclub.realizarPrestamo(prestamo)
            }
            2 -> {
                println("Ingrese el código IMDB del ejemplar que quiere devolver: ")
                val devolucion = readLine()!!.toInt()
                videoclub.realizarDevolucion(devolucion)
            }
            3 -> {
                println("Ingrese el código IMDB del ejemplar que desea controlar: ")
                val auxControl = readLine()!!.toInt()
                videoclub.controlar(auxControl)
            }
            4 -> {
                videoclub.listarEjemplares()
            }
            5 -> {
                print("Ingrese el tipo de ejemplar #${cont}: ")
                var tipoEjemplar = readLine()!!
                videoclub.ejemplares = ingresar(tipoEjemplar, ejemps)
            }
        }
    }while (opMenu != 6)
    println("Ud ha salido del programa. Saludos!")
}

/*
La función ingresar maneja el registro de un ejemplar
Valid la elección del usuario para ingresar los != tipos de ejemplares a partir de la var 'tipoEjemplar'
Recibe por parámetro el array de ejemplares en donde va guardando los ejemplares registrados
 */
fun ingresar(tipoEjemplar: String, ejemplares: ArrayList<Ejemplar>): ArrayList<Ejemplar> {
    var imdb: Int
    var anioPubli: Int
    var zona: Int

    if (tipoEjemplar.toLowerCase() == "dvd") { //Instacia de Dvd
        do {
            print("Ingrese el código IMDB: ")
            imdb = readLine()!!.toInt()
        } while (imdb < 0)

        print("Ingrese el título: ")
        var titulo = readLine()!!

        do {
            print("Ingrese el año de publicación: ")
            anioPubli = readLine()!!.toInt()
        } while (anioPubli < 0 || anioPubli > 2020)

        print("Ingrese el idioma de los subtítulos: ")
        var subs = readLine()!!

        do {
            print("Ingrese la zona: ")
            zona = readLine()!!.toInt()
        } while (zona < 0)

        var dvd = Dvd(imdb, titulo, anioPubli, subs, false, zona, false)

        ejemplares.add(dvd)
        return ejemplares

    } else if (tipoEjemplar.toLowerCase() == "bluray") {//Instancia de BluRay
        do {
            print("Ingrese el código IMDB: ")
            imdb = readLine()!!.toInt()
        } while (imdb < 0)

        print("Ingrese el título: ")
        var titulo = readLine()!!

        do {
            print("Ingrese el año de publicación: ")
            anioPubli = readLine()!!.toInt()
        } while (anioPubli < 0 || anioPubli > 2020)

        print("Ingrese el idioma de los subtítulos: ")
        var subs = readLine()!!

        var bluray = BluRay(imdb, titulo, anioPubli, subs, false, false)
        ejemplares.add(bluray)
        return ejemplares
    } else { //Instancia de Vhs
        try {
            do {
                print("Ingrese el código IMDB: ")
                imdb = readLine()!!.toInt()
            } while (imdb < 0)

            print("Ingrese el título: ")
            var titulo = readLine()!!

            do {
                print("Ingrese el año de publicación: ")
                anioPubli = readLine()!!.toInt()
            } while (anioPubli < 0 || anioPubli > 2020)

            print("Ingrese el idioma de los subtítulos: ")
            var subs = readLine()!!

            //Manejo de fecha (Date)
            print("Ingrese la fecha (dd-mm-yyyy) de fabricación: ")
            var fabricacion = readLine()!!
            var formato = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            var fecha = LocalDate.parse(fabricacion, formato)
            println("¡IMPORTANTE! Recuerde que los ejemplares en formato VHS son históricos y no pueden ser prestados," +
                    "solo usados dentro del Videoclub.")


            var vhs = Vhs(imdb, titulo, anioPubli, subs, true, fecha, false)
            ejemplares.add(vhs)

        } catch (nf: DateTimeParseException) {
            println("Debe ingresar la fecha con el formato indicado")
        }
        return ejemplares
    }
}



