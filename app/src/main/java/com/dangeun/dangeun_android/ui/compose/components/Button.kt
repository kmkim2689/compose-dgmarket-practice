package com.dangeun.dangeun_android.ui.compose.components

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButton(
    modifier: Modifier,
    isScrolled: Boolean,
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
    ) {

    ExtendedFloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(percent = 50),
        text = {
            Text(text = title, color = Color.White)
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = "Add",
                tint = Color.White,
            )
        },
        expanded = !isScrolled,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 8.dp
        ),
        contentColor = Color.Yellow,
        containerColor = Color.Magenta
    )
}
