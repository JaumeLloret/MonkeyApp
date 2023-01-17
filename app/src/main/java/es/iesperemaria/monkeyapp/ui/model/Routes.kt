package es.iesperemaria.monkeyapp.ui.model

sealed class Routes(val route: String) {
    object  LoginScreen: Routes("loginScreen")
    object  MapScreen: Routes("mapScreen")
}
