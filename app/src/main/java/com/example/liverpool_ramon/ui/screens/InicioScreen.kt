package com.example.liverpool_ramon.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.liverpool_ramon.R
import com.example.liverpool_ramon.ui.theme.GrisTexto

@Composable
fun InicioScreen(onEntrarClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_liverpool),
            contentDescription = "Logo de Liverpool",
            modifier = Modifier.size(240.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Bienvenido a Liverpool",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Moda, tecnología y más en un solo lugar",
            style = MaterialTheme.typography.bodyLarge,
            color = GrisTexto
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = onEntrarClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Entrar a la tienda")
        }
    }
}
