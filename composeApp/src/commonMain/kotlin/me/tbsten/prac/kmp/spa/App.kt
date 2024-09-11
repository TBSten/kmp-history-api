package me.tbsten.prac.kmp.spa

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.tbsten.prac.kmp.spa.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "/",
    ) {
        // https://example.com/
        composable("/") {
            ProductListPage(
                navigateToDetail = { id ->
                    navController.navigate("/product/$id")
                },
            )
        }

        // https://example.com/product/{product}
        composable("/product/{id}") {
            val id = it.arguments?.getString("id") ?: "0"
            ProductDetailPage(
                id = id,
                popBackStack = navController::popBackStack,
            )
        }
    }
}
