package com.dangeun.dangeun_android.ui.compose.components

import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        elevation = FloatingActionButtonDefaults.elevation(12.dp),
        contentColor = Color.Yellow,
        containerColor = Color.Magenta
    )
}
