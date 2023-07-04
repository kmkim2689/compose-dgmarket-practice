package com.dangeun.dangeun_android.modules.sale

data class SaleItem(
    val id: Long,
    val imageUrl: String,
    val title: String,
    val location: String,
    // 초 단위
    val time: Long,
    val price: Long,
    val likes: Long,
    val chats: Long
)
