class BluRay (codImdb: Int, titulo: String, anioPublicacion: Int, idiomaSub: String,
              esHistorico: Boolean = false, esPrestado: Boolean)
    : Ejemplar(codImdb, titulo, anioPublicacion, idiomaSub, esHistorico, esPrestado, esUsado = false) {

    override fun mostrarEjemplar(){
        super.mostrarEjemplar()
        println("*****************************")
    }
}