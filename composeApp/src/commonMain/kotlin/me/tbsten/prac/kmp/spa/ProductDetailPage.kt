package me.tbsten.prac.kmp.spa

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductDetailPage(
    id: String,
    popBackStack: () -> Unit,
) {
    var product by remember { mutableStateOf<Product?>(null) }
    LaunchedEffect(id) {
        product = getProductById(id)
    }

    Column {
        IconButton(onClick = popBackStack) {
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "戻る")
        }
        product?.let {
            ProductDetailPage(
                product = it,
            )
        } ?: LoadingPage()
    }
}

@Composable
private fun LoadingPage() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ProductDetailPage(product: Product) {
    Column {
        Text(
            product.id,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.75f),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        )

        Text(
            product.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
        )

        HorizontalDivider()

        Text(
            text = product.content,
            modifier = Modifier.padding(16.dp),
        )

    }
}
