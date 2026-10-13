package com.example.liverpool_ramon.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.liverpool_ramon.model.ProductDetail
import com.example.liverpool_ramon.ui.theme.GrisTexto
import com.example.liverpool_ramon.ui.theme.VerdeEnvio

@Composable
fun ProductoCard(producto: ProductDetail, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        ProductoImagen(
            image = producto.image,
            descripcion = producto.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = producto.brand,
                style = MaterialTheme.typography.labelMedium,
                color = GrisTexto
            )
            Text(
                text = producto.name,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$" + String.format("%,.2f", producto.price),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            if (producto.isFreeShipping) {
                Text(
                    text = "Envío gratis",
                    style = MaterialTheme.typography.labelMedium,
                    color = VerdeEnvio
                )
            }
        }
    }
}

// image puede ser null, en ese caso se muestra un cuadro gris
@Composable
fun ProductoImagen(image: Int?, descripcion: String, modifier: Modifier = Modifier) {
    if (image != null) {
        Image(
            painter = painterResource(id = image),
            contentDescription = descripcion,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    } else {
        Box(
            modifier = modifier.background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Sin imagen", color = GrisTexto)
        }
    }
}
