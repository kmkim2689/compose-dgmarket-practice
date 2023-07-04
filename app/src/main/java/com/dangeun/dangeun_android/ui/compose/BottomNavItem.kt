package com.dangeun.dangeun_android.ui.compose

import androidx.compose.ui.graphics.vector.ImageVector

// 내비게이션 바에서 보여주어야 할 정보들을 데이터클래스로 정해놓음
data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    // 0이면 뱃지를 안 보여줌
    val badgeCount: Int = 0
)