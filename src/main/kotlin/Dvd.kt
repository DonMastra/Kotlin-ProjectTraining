class Dvd (codImdb: Int, titulo: String, anioPublicacion: Int, idiomaSub: String, esHistorico: Boolean = false,
           val zona: Int, esPrestado: Boolean)
    : Ejemplar(codImdb, titulo, anioPublicacion, idiomaSub, esHistorico, esPrestado, esUsado = false){

    override fun mostrarEjemplar(){
        super.mostrarEjemplar()
        println("Zona: ${this.zona}")
        println("*****************************")
    }
}