import java.time.LocalDate

class Vhs (codImdb: Int, titulo: String, anioPublicacion: Int, idiomaSub: String, esHistorico: Boolean = true,
           val fechaFab: LocalDate, esPrestado: Boolean)
    : Ejemplar(codImdb, titulo, anioPublicacion, idiomaSub, esHistorico, esPrestado, esUsado = false) {

    override fun prestar(){
        esPrestado = false
        esUsado = true
        println("El ejemplar será usado dentro del local")
    }

    override fun devolver(){
        esPrestado = false
        esUsado = false
        println("Se devolvió un ejemplar histórico")
    }

    override fun mostrarEjemplar(){
        super.mostrarEjemplar()
        println("Es un ejemplar histórico")
        println("Fecha de fabricación: ${this.fechaFab}")
        println("*****************************")
    }
}