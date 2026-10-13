package com.example.liverpool_ramon.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.liverpool_ramon.R
import com.example.liverpool_ramon.model.ProductDetail
import com.example.liverpool_ramon.model.Review

class ProductoViewModel : ViewModel() {

    // mutableStateListOf avisa a Compose cuando un producto cambia (por ejemplo, favorito)
    val productos = mutableStateListOf(
        ProductDetail(
            brand = "Ben Sherman",
            name = "Playera básica",
            price = 299.0,
            rating = 4.5f,
            reviewCount = 4,
            isFreeShipping = false,
            description = "Playera de algodón con corte clásico, cómoda para el día a día.",
            image = R.drawable.playera,
            reviews = listOf(
                Review("Ana", "La tela es suave y no se encoge.", 5),
                Review("Luis", "Buena calidad por el precio.", 4),
                Review("Carla", "La talla es un poco grande.", 4),
                Review("Jorge", "Me gustó, compraré otro color.", 5)
            )
        ),
        ProductDetail(
            brand = "Sportline",
            name = "Tenis deportivos",
            price = 1499.0,
            rating = 4.25f,
            reviewCount = 4,
            description = "Tenis ligeros con suela acolchada, ideales para correr o caminar.",
            image = R.drawable.tenis,
            reviews = listOf(
                Review("Miguel", "Muy cómodos para correr.", 5),
                Review("Sofía", "Llegaron rápido y en buen estado.", 4),
                Review("Diego", "Se ensucian fácil.", 3),
                Review("Valeria", "Excelentes, los recomiendo.", 5)
            )
        ),
        ProductDetail(
            brand = "Google",
            name = "Smartphone 128 GB",
            price = 6999.0,
            rating = 4.0f,
            reviewCount = 4,
            description = "Teléfono con pantalla de 6.5 pulgadas, 128 GB de almacenamiento y cámara doble.",
            image = R.drawable.celular,
            reviews = listOf(
                Review("Fernanda", "La batería dura todo el día.", 5),
                Review("Raúl", "Las fotos de noche no son tan buenas.", 3),
                Review("Paola", "Rápido y fácil de usar.", 4),
                Review("Andrés", "Buen equilibrio entre precio y calidad.", 4)
            )
        ),
        ProductDetail(
            brand = "Seiko",
            name = "Reloj clásico",
            price = 2199.0,
            rating = 4.75f,
            reviewCount = 4,
            description = "Reloj análogo con extensible de acero inoxidable y fechador.",
            image = R.drawable.reloj,
            reviews = listOf(
                Review("Ricardo", "Se ve muy elegante.", 5),
                Review("Mónica", "Lo regalé y le encantó.", 5),
                Review("Iván", "El extensible es algo pesado.", 4),
                Review("Lucía", "Muy bonito diseño.", 5)
            ),
            isFavorite = true
        ),
        ProductDetail(
            brand = "Charles & Keith",
            name = "Bolsa de mano",
            price = 1299.0,
            rating = 4.0f,
            reviewCount = 4,
            description = "Bolsa de mano con compartimentos interiores y cierre metálico.",
            image = R.drawable.bolsa,
            reviews = listOf(
                Review("Daniela", "Cabe todo lo que necesito.", 5),
                Review("Gabriela", "El color es igual al de la foto.", 4),
                Review("Teresa", "El cierre se atora a veces.", 3),
                Review("Mariana", "Muy práctica para el trabajo.", 4)
            )
        ),
        ProductDetail(
            brand = "Beats",
            name = "Audífonos inalámbricos",
            price = 1899.0,
            rating = 4.25f,
            reviewCount = 4,
            description = "Audífonos Bluetooth con cancelación de ruido y hasta 30 horas de batería.",
            image = R.drawable.audifonos,
            reviews = listOf(
                Review("Óscar", "El sonido es muy claro.", 5),
                Review("Natalia", "La cancelación de ruido funciona bien.", 4),
                Review("Héctor", "Después de horas aprietan un poco.", 3),
                Review("Elena", "La batería dura muchísimo.", 5)
            )
        )
    )

    fun obtenerProducto(id: String): ProductDetail? {
        return productos.find { it.id == id }
    }

    fun cambiarFavorito(id: String) {
        val index = productos.indexOfFirst { it.id == id }
        if (index != -1) {
            val producto = productos[index]
            productos[index] = producto.copy(isFavorite = !producto.isFavorite)
        }
    }
}
