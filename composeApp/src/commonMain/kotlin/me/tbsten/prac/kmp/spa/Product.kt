package me.tbsten.prac.kmp.spa

import kotlinx.coroutines.delay

data class Product(
    val id: String,
    val title: String,
    val content: String,
)

val Products = List(15) {
    Product(
        id = "p-$it",
        title = "my product $it",
        content = "my product $it ".repeat(100),
    )
}

suspend fun getProductById(id: String): Product {
    delay(1_000)
    return Products.first { it.id == id }
}
