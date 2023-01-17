package com.jle.monkeyfilmapp.map.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.jle.monkeyfilmapp.register.ui.MapViewModel
@Composable
fun MapScreen(mapViewModel: MapViewModel, navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val school = LatLng(38.55359897196608, -0.12057169825429333)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(school, 10f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = school),
                title = "IES Pere María",
                snippet = "Estamos aqui"
            )
        }
    }
}
