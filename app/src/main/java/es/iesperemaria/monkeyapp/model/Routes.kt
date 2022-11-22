package es.iesperemaria.monkeyapp.model

sealed class Routes(val route: String) {
    object  ScreenOne: Routes("screenOne")
    object  ScreenTwo: Routes("screenTwo")
    object  ScreenThree: Routes("screenThree/{score}") {
        fun createRoute(score: Int) = "screenThree/$score"
    }
    object  ScreenFour: Routes("screenFour?title={title}") {
        fun createRoute(title: String) = "screenFour?title=$title"
    }
}
