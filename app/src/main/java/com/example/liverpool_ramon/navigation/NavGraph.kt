package com.example.liverpool_ramon.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.liverpool_ramon.ui.screens.DetallesProductoScreen
import com.example.liverpool_ramon.ui.screens.InicioScreen
import com.example.liverpool_ramon.ui.screens.ProductosScreen
import com.example.liverpool_ramon.ui.viewmodel.ProductoViewModel

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: ProductoViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "inicio",
        modifier = modifier
    ) {
        composable("inicio") {
            InicioScreen(
                onEntrarClick = { navController.navigate("productos") }
            )
        }

        composable("productos") {
            ProductosScreen(
                productos = viewModel.productos,
                onProductoClick = { id -> navController.navigate("detalles/$id") }
            )
        }

        composable(
            route = "detalles/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            val producto = viewModel.obtenerProducto(id)

            if (producto != null) {
                DetallesProductoScreen(
                    producto = producto,
                    onVolverClick = { navController.popBackStack() },
                    onFavoritoClick = { viewModel.cambiarFavorito(id) }
                )
            } else {
                Text("Producto no encontrado")
            }
        }
    }
}
