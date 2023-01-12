package es.iesperemaria.monkeyapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import es.iesperemaria.monkeyapp.ui.model.Routes
import es.iesperemaria.monkeyapp.ui.screens.*

@Composable
fun CustomNavigator() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Routes.ScreenOne.route) {
        composable(route = Routes.ScreenOne.route) {
            ScreenOne(navigationController = navigationController)
        }
        composable(route = Routes.ScreenTwo.route) {
            ScreenTwo(navigationController = navigationController)
        }
        composable(route = Routes.ScreenThree.route,
            arguments = listOf(navArgument("score"){
                type = NavType.IntType
            })) { navBackStackEntry ->
            ScreenThree(
                navigationController = navigationController,
                score = navBackStackEntry
                    .arguments?.getInt("score") ?:0
            )
        }
        composable(
            route = Routes.ScreenFour.route,
            arguments = listOf(navArgument("title"){
                defaultValue = "Hola Mundo"
            })
        ) {
            ScreenFour(
                navigationController = navigationController,
                title = it.arguments?.getString("title")
            )
        }
    }
}