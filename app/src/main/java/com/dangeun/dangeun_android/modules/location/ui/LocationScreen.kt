package com.dangeun.dangeun_android.modules.location.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dangeun.dangeun_android.modules.category.CategoryContainer
import com.dangeun.dangeun_android.modules.category.CategoryRepository


@Composable
fun LocationScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val categoryRepository = CategoryRepository()
        val categoryItems = categoryRepository.getAllCategories()

        CategoryContainer(categoryItems = categoryItems)
    }
}