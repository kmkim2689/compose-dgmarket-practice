package com.dangeun.dangeun_android.modules.life

data class LifeItem(
    val tag: String,
    val title: String,
    val desc: String,
    val location: String,
    val time: String,
    val hitCount: Long,
    val likeCount: Long?,
    val commentCount: Long?,
    val imageUrl: String?,
    val imageCount: Long
)
