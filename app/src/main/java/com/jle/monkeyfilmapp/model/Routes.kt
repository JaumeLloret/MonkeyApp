package com.jle.monkeyfilmapp.model

sealed class Routes(val route: String) {
    object  ScreenOne: Routes("screenOne")
    object  ScreenTwo: Routes("screenTwo")
    object  ScreenThree: Routes("screenThree")
    object  ScreenFour: Routes("screenFour/{score}") {
        fun createRoute(score: Int) = "screenFour/$score"
    }
    object  ScreenFive: Routes("screenFive?title={title}") {
        fun createRoute(title: String) = "screenFive?title=$title"
    }
}
