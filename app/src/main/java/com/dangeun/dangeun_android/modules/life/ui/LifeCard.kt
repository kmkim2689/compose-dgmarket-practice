package com.dangeun.dangeun_android.modules.life.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dangeun.dangeun_android.modules.life.LifeItem
import com.dangeun.dangeun_android.ui.compose.components.ImageCard
import com.dangeun.dangeun_android.ui.compose.components.PostTag

@Composable
fun LifeCard(lifeItem: LifeItem) {
    Box(modifier = Modifier
        .fillMaxWidth()
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(
                        weight = 0.9f,
                        fill = true
                    )
            ) {
                if (lifeItem.imageUrl != null) {
                    Column(
                        modifier = Modifier
                            .weight(weight = 0.8f, fill = true)
                    ) {
                        PostTag(text = lifeItem.tag)
                        Text(text = lifeItem.title)
                        Text(text = lifeItem.desc)
                    }
                    ImageCard(imageUrl = lifeItem.imageUrl, contentDescription = lifeItem.desc)
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        PostTag(text = lifeItem.tag)
                        Text(text = lifeItem.title)
                        Text(text = lifeItem.desc)
                    }
                }

            }

            // 지역, 시간, 조회, 댓글, 좋아요수
            Column(
                modifier = Modifier
                    .weight(
                        weight = 0.1f,
                        fill = true
                    )
            ) {
                Text(text = "${lifeItem.location}·${lifeItem.time}·조회 ${lifeItem.hitCount}")
            }
        }
    }

}

@Preview
@Composable
fun LifeCardPreview() {
    LifeCard(lifeItem = LifeItem(
        tag = "일상",
        title = "백석역근처 택배 받아주실분? 사람 없어도 돼요",
        desc = "죄송하지만 백석역 근처 거주자 분 중에 택배 받아주실 분 계신가요",
        location = "정발산동",
        time = "어제",
        hitCount = 480L,
        commentCount = 7,
        imageUrl = null,
        imageCount = 0,
        likeCount = 1
    ))
}