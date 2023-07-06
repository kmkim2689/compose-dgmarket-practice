package com.dangeun.dangeun_android.ui.compose.components

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Category(icon: ImageVector, title: String) {
    Column(
        modifier = Modifier
            // aspectRatio : 가로 세로 비율 조정
            .aspectRatio(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title
        )

        Spacer(
            modifier = Modifier
                .height(2.dp)
        )

        Text(text = title)
    }
}

@Preview
@Composable
fun CategoryPreview() {
    Category(
        icon = Icons.Default.ShoppingCart,
        title = "알바"
    )
}