package dev.dizel.ambientstore.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import dev.dizel.ambientstore.screens.soundlist.SoundList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AmbientStoreUi() }
    }
}

@Composable
fun AmbientStoreUi() {
    SoundList()
}
