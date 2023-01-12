package com.jle.monkeyfilmapp.ui.model

sealed class Routes(val route: String) {
    object  LoginScreen: Routes("loginScreen")
    object  RegisterScreen: Routes("registerScreen")
}
