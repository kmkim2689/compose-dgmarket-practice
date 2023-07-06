package com.dangeun.dangeun_android.modules.category

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

class CategoryRepository {
    fun getAllCategories(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                title = "알바",
                icon = Icons.Default.ShoppingCart
            ),
            CategoryItem(
                title = "중고차 직거래",
                icon = Icons.Default.Notifications
            ),
            CategoryItem(
                title = "부동산 직거래",
                icon = Icons.Default.Home
            ),
            CategoryItem(
                title = "농수산물",
                icon = Icons.Default.DateRange
            ),
            CategoryItem(
                title = "음식점",
                icon = Icons.Default.Share
            ),
            CategoryItem(
                title = "카페·디저트",
                icon = Icons.Default.List
            ),
            CategoryItem(
                title = "운동",
                icon = Icons.Default.Lock
            ),
            CategoryItem(
                title = "이사·용달",
                icon = Icons.Default.ShoppingCart
            ),
            CategoryItem(
                title = "수리",
                icon = Icons.Default.Star
            ),
            CategoryItem(
                title = "과외·클래스",
                icon = Icons.Default.ShoppingCart
            ),
            CategoryItem(
                title = "뷰티샵",
                icon = Icons.Default.Favorite
            ),
            CategoryItem(
                title = "미용실",
                icon = Icons.Default.Face
            ),
            CategoryItem(
                title = "인테리어시공",
                icon = Icons.Default.DateRange
            ),
            CategoryItem(
                title = "청소",
                icon = Icons.Default.AccountCircle
            ),
            CategoryItem(
                title = "세탁소",
                icon = Icons.Default.Send
            ),
            CategoryItem(
                title = "취미",
                icon = Icons.Default.Phone
            )
        )
    }

}