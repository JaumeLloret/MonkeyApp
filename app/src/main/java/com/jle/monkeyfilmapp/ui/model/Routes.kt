package com.jle.monkeyfilmapp.ui.model

sealed class Routes(val route: String) {
    object  LoginScreen: Routes("loginScreen")
    object  RegisterScreen: Routes("registerScreen")
    /*object  ScreenFour: Routes("screenFour/{score}") {
        fun createRoute(score: Int) = "screenFour/$score"
    }
    object  ScreenFive: Routes("screenFive?title={title}") {
        fun createRoute(title: String) = "screenFive?title=$title"
    }*/
}
