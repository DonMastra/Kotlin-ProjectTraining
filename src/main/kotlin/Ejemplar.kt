open class Ejemplar (val codImdb: Int, val titulo: String, val anioPublicacion: Int,
                     var idiomaSub: String, var esHistorico: Boolean, var esPrestado: Boolean, var esUsado: Boolean) {

    open fun prestar(){
        esPrestado = true
    }

    open fun devolver(){
        esPrestado = false
    }

    open fun mostrarEjemplar(){
        println("""
            Cod. IMDB: ${this.codImdb}
            Título: ${this.titulo}
            Año de publicación: ${this.anioPublicacion}
            Idioma subtítulo: ${this.idiomaSub}
            Histórico?: ${this.esHistorico}
            Prestado?: ${this.esPrestado}
            Usado?: ${this.esUsado}
        """.trimIndent())
    }
}