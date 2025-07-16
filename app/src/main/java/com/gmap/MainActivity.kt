package com.gmap

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gmap.ui.theme.GMapTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GMapTheme {
                ComposeGMapDemo()
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ComposeGMapDemo() {
    val _bangloreMbrdi = LatLng(12.9857, 77.7272)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(_bangloreMbrdi, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = _bangloreMbrdi),
            title = "Banglore",
            snippet = "Marker in Banglore"
        )
 }
}
