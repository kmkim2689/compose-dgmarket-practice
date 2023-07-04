package com.dangeun.dangeun_android.ui.compose.components

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition


/*
 Glide를 사용하여 이미지를 로드하고, 로드가 완료되면 onResourceReady 콜백을 호출하여 이미지를 처리하는 역할을 합니다. 아래는 코드의 각 부분에 대한 설명입니다:

Glide.with(context): Glide 라이브러리를 사용하기 위해 컨텍스트를 지정합니다. context는 이미지 로딩에 필요한 리소스와 수명 주기 정보를 제공하는 컨텍스트입니다.

.asBitmap(): Glide에게 이미지를 비트맵 형식으로 로드하도록 지시합니다. .asBitmap()을 사용하면 비트맵 형식으로 이미지를 받을 수 있습니다.

.load(imageUrl): 로드할 이미지의 URL을 지정합니다. imageUrl은 로드하려는 이미지의 URL입니다.

.into(object : SimpleTarget<Bitmap>() { ... }): 로드된 이미지를 처리하기 위한 SimpleTarget을 지정합니다. SimpleTarget은 Glide가 이미지 로딩이 완료되면 호출하는 콜백 메서드를 제공합니다. 이 콜백에서 onResourceReady 함수를 오버라이드하여 로드된 이미지를 처리할 수 있습니다.

override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) { ... }: 이미지 로딩이 완료되면 호출되는 콜백 메서드입니다. 이 메서드에서는 resource로 로드된 비트맵 이미지를 전달받습니다. 이후 onImageLoaded(resource.asImageBitmap())를 호출하여 비트맵을 ImageBitmap으로 변환하고, 이를 처리하는 onImageLoaded 콜백 함수를 호출합니다.
 */

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageCard(
    imageUrl: String,
    contentDescription: String
) {
    Box(modifier = Modifier
        .size(120.dp)
        .clip(shape = RoundedCornerShape(10.dp))
    ) {
        Log.d("imageUrl", imageUrl)

        // coil : https://github.com/coil-kt/coil#jetpack-compose
        AsyncImage(
            contentScale = ContentScale.FillBounds,
            model = imageUrl,
            contentDescription = contentDescription,
        )
    }

}

@Composable
fun ImageCardCommunity(
    imageUrl: String,
    contentDescription: String
) {
    Box(modifier = Modifier
        .size(80.dp)
        .clip(shape = RoundedCornerShape(10.dp))
    ) {
        Log.d("imageUrl", imageUrl)

        // coil : https://github.com/coil-kt/coil#jetpack-compose
        AsyncImage(
            contentScale = ContentScale.FillBounds,
            model = imageUrl,
            contentDescription = contentDescription,
        )
    }

}