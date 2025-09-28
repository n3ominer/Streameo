package com.example.streameo.ui.components.home_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.streameo.ui.components.common.BlurryIconButton

@Composable
fun HomeCustomTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .clickable { },
            color = Color.Gray.copy(alpha = 0.5f),
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://robohash.org/243.40.31.160.png"),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )
        }

        BlurryIconButton(Icons.Filled.MoreVert, onClick = { })
    }
}