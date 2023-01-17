package es.iesperemaria.monkeyapp.maps.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(mapViewModel: MapViewModel, navigationController: NavHostController) {
    val school = LatLng(38.55359897196608, -0.12057169825429333)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(school, 13f)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        GoogleMap(
           modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Polyline(points = listOf(
                LatLng(38.55359897196608, -0.12057169825429333),
                LatLng(39.55359897196608, -0.12057169825429333),
                LatLng(40.55359897196608, -0.12057169825429333),
                LatLng(41.55359897196608, -0.12057169825429333)
            ),
            color = Color.Red
                )
        }
    }
}