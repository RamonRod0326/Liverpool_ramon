package com.example.liverpool_ramon.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.liverpool_ramon.model.ProductDetail

@Composable
fun ProductoList(
    productos: List<ProductDetail>,
    onProductoClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // LazyVerticalGrid ya tiene scroll propio cuando las tarjetas no caben
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(productos) { producto ->
            ProductoCard(
                producto = producto,
                onClick = { onProductoClick(producto.id) }
            )
        }
    }
}
