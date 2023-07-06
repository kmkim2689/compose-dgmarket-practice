package com.dangeun.dangeun_android.modules.category

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dangeun.dangeun_android.ui.compose.components.Category

@Composable
fun CategoryContainer(categoryItems: List<CategoryItem>) {

    // expand state
    // remember -> survive while recomposition
    var expandedState by remember {
        mutableStateOf(false)
    }

    // expanding animation


    Card(
        modifier = Modifier
            .fillMaxWidth()
            // animateContentSize :
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
    ) {
        // using lazygrid(LazyVerticalGrid)
        /* ------->
        1  2  3  4
        5  6  7  8
        ...
         */

        LazyVerticalGrid(
            // columns : 한줄에 나올 아이템 개수
            // GridCells.Fixed(Int) : 한줄에 나올 아이템 개수가 정해진 대로 고정
            // GridCells.Adaptive(Int) : 아이템(each grid cell)의 최소 크기
            // => 이것을 사용하면 화면 크기에 따라서 동적으로 조절 가능(최소 100dp 권장)
            columns = GridCells.Adaptive(80.dp),
            // content : the lazygridscope which describes the content
            content = {
                if (expandedState) {
                    items(categoryItems) {item ->
                        Category(
                            icon = item.icon,
                            title = item.title
                        )
                    }
                    // 접기 : 길쭉하게 하나의 행을 모두 차지해야 함. : GridItemSpan 이용
                    // maxLineSpan으로 설정하면 몇개의 셀을 차지할지 하드코딩하지 않아도 된다.
                    item(
                        span = { GridItemSpan(maxLineSpan) },
                    ) {
                        Row(
                            modifier = Modifier
                                .clickable {
                                   expandedState = !expandedState
                                },
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "접기"
                            )

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = "Close"
                            )
                        }


                    }
                } else {
                    itemsIndexed(categoryItems) { index, item ->
                        if (index < 7) {
                            Category(
                                icon = item.icon,
                                title = item.title
                            )
                        }
                    }
                    item() {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    expandedState = !expandedState
                                }
                        ) {
                            Category(icon = Icons.Default.KeyboardArrowDown, title = "더보기")
                        }

                    }

                }

            }
        )

    }

}

/*
LazyVerticalGrid에서 GridCells.Adaptive()를 사용하여 한 줄 당 아이템 개수를 유연하게 조정하는 경우, 실제로 한 줄에 몇 개의 아이템이 표시되는지 확인하려면 LazyVerticalGridScope의 calculateItemPosition 함수를 활용할 수 있습니다. 이 함수는 현재 아이템의 인덱스를 기준으로 한 줄에 표시되는 첫 번째 아이템부터 마지막 아이템까지의 인덱스를 계산해줍니다.
 */


@Preview
@Composable
fun CategoryContainerPreview() {
    CategoryContainer(CategoryRepository().getAllCategories())
}
