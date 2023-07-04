package com.dangeun.dangeun_android.ui.compose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PostCard() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(152.dp)
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(bounded = true, color = Color.Gray)
        ) { }
        .drawBehind {
            // drawBehind : 아래 경계선 그리기
            val borderSize = 0.2.dp.toPx()
            drawLine(
                color = Color.Gray,
                start = Offset(52f, size.height),
                end = Offset(size.width - 52, size.height),
                strokeWidth = borderSize
            )
        })
}
