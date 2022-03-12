package dev.dizel.ambientstore.screens.soundlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import dev.dizel.ambientstore.R
import dev.dizel.ambientstore.model.domain.entities.Sound
import dev.dizel.ambientstore.khulaFonts
import dev.dizel.ambientstore.commonUi.DarkTeal
import dev.dizel.ambientstore.commonUi.Teal

@Composable
fun SoundList(
    viewModel: SoundListViewModel = viewModel()
) {
    val state = viewModel.state.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkTeal),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item { PlayerItem() }

        state.soundList.forEach {
            item { SoundItem(sound = it) }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun PlayerItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(20.dp),
        backgroundColor = Teal,
        shape = RoundedCornerShape(20.dp),
    ) {
        Row() {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_skip_previous),
                    contentDescription = "previous",
                    tint = Color.White,
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_play_arrow),
                    contentDescription = "play",
                    tint = Color.White,
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_skip_next),
                    contentDescription = "next",
                    tint = Color.White,
                )
            }
        }
    }
}

@OptIn(
    ExperimentalMaterialApi::class,
    coil.annotation.ExperimentalCoilApi::class,
    androidx.compose.ui.graphics.ExperimentalGraphicsApi::class
)
@Composable
internal fun SoundItem(
    sound: Sound
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .shadow(20.dp),
        backgroundColor = Color.DarkGray,
        shape = RoundedCornerShape(20.dp),
        onClick = {  },
    ) {
        Image(
            painter = rememberImagePainter(
                data = sound.imageUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = sound.name,
            contentScale = ContentScale.Crop,
        )

        Box(
            contentAlignment = Alignment.BottomEnd,
        ) {
            Text(
                text = sound.name.uppercase(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 26.sp,
                    fontFamily = khulaFonts,
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier.padding(
                    PaddingValues(
                        vertical = 16.dp,
                        horizontal = 32.dp
                    )
                ),
            )
        }
    }
}