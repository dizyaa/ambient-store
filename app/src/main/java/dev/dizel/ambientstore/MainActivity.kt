package dev.dizel.ambientstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import dev.dizel.ambientstore.soundlist.SoundList

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
