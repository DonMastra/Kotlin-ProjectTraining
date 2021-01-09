class Videoclub (val nombre: String, ejemplares: ArrayList<Ejemplar>) {

    var ejemplares: ArrayList<Ejemplar> = ejemplares

    /*
        Realiza el préstamo de un ejemplar
        Recorremos el arreglo de ejemplares, validamos que el cod 'prestamo' esté dentro del array
        Validamos que NO sea histórico. Si es histórico, validamos si se desea usarlo dentro del local
        Sólo se pueden prestar Dvd o Bluray (if esHistorico == false, se puede prestar)
        Al prestar colocamos una propiedad 'esPrestado' en true, si es histórico 'esUsado' en true
         */
    fun realizarPrestamo(prestamo: Int) {

        var bandera: String? = null

        for (ejemplar in this.ejemplares){
            if (prestamo == ejemplar.codImdb){
                if(!ejemplar.esHistorico){
                    ejemplar.prestar()
                    println("Préstamo del ejemplar ${ejemplar.titulo} realizado con éxito!")
                    break
                }else{
                    println("No se puede prestar el ejemplar. Es histórico.")
                    println("Desea usar el ejemplar histórico dentro del local? y/N")
                    var auxDecision = readLine()!!
                    if (auxDecision.toLowerCase() == "y"){
                        ejemplar.prestar()
                    }else{
                        println("Decidió no usar el ejemplar dentro del videoclub")
                    }
                }
            }
            else{
                bandera = "El cod. IMDB ingresado es incorrecto o el ejemplar es inexistente"
            }
        }
        if (bandera != null){
            println(bandera)
        }
    }

    fun realizarDevolucion(devolucion: Int) {
        var bandera: String? = null

        /*Recorremos el arreglo de ejemplares, validamos que el cod 'devolucion' esté dentro del array
        y validamos si el ejemplar está prestado o siendo usado (en caso de vhs)
         */
        for (ejemplar in this.ejemplares){
            if (devolucion == ejemplar.codImdb){
                if (ejemplar.esPrestado || ejemplar.esUsado){
                    ejemplar.devolver()
                    println("Devolución realizada con éxito!")
                    break
                }else{
                    println("El ejemplar no fue prestado ni está siendo usado.")
                    println("Se está devolviendo una copia")
                    //TODO: agregar un ejemplar más al array
                }
            }else{
                bandera = "El cod. IMDB ingresado es incorrecto o el ejemplar es inexistente"
            }
        }
        if (bandera != null){
            println(bandera)
        }
    }

    /*
    Valida si un Dvd o BluRay está prestado
    y también valida si un Vhs está siendo usado
     */
    fun controlar(auxControl: Int) {

        var bandera: String? = null

        for (ejemplar in this.ejemplares){
            if (auxControl == ejemplar.codImdb){
                if (ejemplar.esPrestado){
                    println("El ejemplar ${ejemplar.codImdb}, ${ejemplar.titulo}, fue prestado")
                }else{
                    if (ejemplar.esUsado){
                        println("El ejemplar ${ejemplar.codImdb}, ${ejemplar.titulo}, está siendo usado en el local, " +
                                "ya que es histórico")
                    }
                }
            }else{
                bandera = "El cod. IMDB ingresado es incorrecto o el ejemplar es inexistente"
            }
        }
        if (bandera != null){
            println(bandera)
        }
    }

    /*
    Muestra un listado de ejemplares y sus propiedades y estados
     */
    fun listarEjemplares(){
        for (ejemplar in ejemplares){
            ejemplar.mostrarEjemplar()
        }
    }
}
