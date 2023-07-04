package com.dangeun.dangeun_android.ui.compose.components

import android.nfc.Tag
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostTag(text: String) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(
                top = 2.dp,
                bottom = 2.dp,
                start = 4.dp,
                end = 4.dp
            )
            .clip(shape = RoundedCornerShape(8.dp))
    ) {
        Text(
            text = text,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun TagPreview() {
    PostTag(text = "test")
}