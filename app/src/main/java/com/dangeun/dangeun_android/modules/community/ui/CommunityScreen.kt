package com.dangeun.dangeun_android.modules.community.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dangeun.dangeun_android.modules.life.LifeItemRepository
import com.dangeun.dangeun_android.modules.life.ui.LifeCard
import com.dangeun.dangeun_android.modules.sale.SaleItemRepository
import com.dangeun.dangeun_android.modules.sale.ui.SaleCard
import com.dangeun.dangeun_android.ui.compose.components.AppBar
import com.dangeun.dangeun_android.ui.compose.components.FloatingActionButton

@Composable
fun CommunityScreen() {

    val lazyListState = rememberLazyListState()
    val isScrolled: Boolean by remember {
        derivedStateOf {
            // lazyList의 첫번째 아이템의 좌표가 0을 넘어서면 true
            lazyListState.firstVisibleItemIndex > 0
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Log.d("isScrolled", isScrolled.toString())
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AppBar(location = "중산동", menu = "community")
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp)
            ) {
                val lifeItemRepository = LifeItemRepository()
                val getAllData = lifeItemRepository.getAllData()

                LazyColumn(
                    // 스크롤을 감지하기 위하여, 반드시 state 변수를 설정해야 한다...
                    state = lazyListState,
                    modifier = Modifier
                ) {
                    items(items = getAllData) { lifeItem ->
                        LifeCard(lifeItem = lifeItem)
                    }
                }
            }
        }


        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 100.dp, end = 16.dp),
            isScrolled = isScrolled,
            icon = Icons.Default.Add,
            title = "글쓰기",
        ) {
            // click event
        }


    }

}