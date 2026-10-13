package com.example.liverpool_ramon.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liverpool_ramon.model.ProductDetail
import com.example.liverpool_ramon.ui.components.ProductoImagen
import com.example.liverpool_ramon.ui.theme.GrisTexto
import com.example.liverpool_ramon.ui.theme.VerdeEnvio

@Composable
fun DetallesProductoScreen(
    producto: ProductDetail,
    onVolverClick: () -> Unit,
    onFavoritoClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TextButton(onClick = onVolverClick) {
            Text("< Volver")
        }
        ProductoImagen(
            image = producto.image,
            descripcion = producto.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = producto.brand, color = GrisTexto)
                    Text(
                        text = producto.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
                IconButton(onClick = onFavoritoClick) {
                    Text(
                        text = if (producto.isFavorite) "♥" else "♡",
                        fontSize = 28.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Text(
                text = "$" + String.format("%,.2f", producto.price),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            if (producto.isFreeShipping) {
                Text(text = "Envío gratis", color = VerdeEnvio, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "★ " + String.format("%.1f", producto.rating) +
                        "  (" + producto.reviewCount + " comentarios)",
                color = GrisTexto
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Descripción", fontWeight = FontWeight.Bold)
            Text(text = producto.description)

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Comentarios (" + producto.reviewCount + ")",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            for (review in producto.reviews) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = review.author, fontWeight = FontWeight.Bold)
                        Text(
                            text = "★".repeat(review.rating) + "☆".repeat(5 - review.rating),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(text = review.comment)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
