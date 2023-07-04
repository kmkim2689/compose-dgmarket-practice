package com.dangeun.dangeun_android.modules.sale.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dangeun.dangeun_android.modules.sale.SaleItem
import com.dangeun.dangeun_android.ui.compose.components.ImageCard

@Composable
fun SaleCard(saleItem: SaleItem) {
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
        }) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ImageCard(
                imageUrl = saleItem.imageUrl,
                contentDescription = saleItem.title
            )

            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = saleItem.title,
                    fontSize = 16.sp
                )

                Text(
                    text = "${saleItem.location} · ${saleItem.time}분 전",
                    color = Color.LightGray,
                    fontSize = 12.sp
                )

                Text(
                    text = "${saleItem.price}원",
                    fontWeight = FontWeight.W700
                )

                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                ) {

                }
            }
        }
    }
}