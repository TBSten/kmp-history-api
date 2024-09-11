package me.tbsten.prac.kmp.spa

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import me.tbsten.prac.kmp.spa.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.route
    LaunchedEffect(currentRoute) {
        println(currentRoute)
        currentRoute?.let {
            navigate(currentRoute)
        }
    }

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

private val NavBackStackEntry.route: String?
    get() {
        val baseRoute = this.destination.route
        var resolvedRoute = baseRoute ?: return null
        this.arguments?.keySet()?.forEach { argumentKey ->
            val argumentValueStr = this.arguments?.get(argumentKey).toString()
            resolvedRoute = resolvedRoute.replace("{$argumentKey}", argumentValueStr)
        }
        return resolvedRoute
    }
