package me.tbsten.prac.kmp.spa

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductListPage(
    navigateToDetail: (id: String) -> Unit,
) {
    LazyColumn {
        items(Products) { product ->

            Row(
                Modifier
                    .clickable { navigateToDetail(product.id) }
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(
                    product.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

        }
    }
}
