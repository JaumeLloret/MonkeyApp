package com.jle.monkeyfilmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jle.monkeyfilmapp.home.ui.composables.MediaListView
import com.jle.monkeyfilmapp.model.Routes
import com.jle.monkeyfilmapp.ui.theme.MonkeyFilmAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonkeyFilmAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    /*val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.ScreenOne.route
                    ) {
                        composable(route = Routes.ScreenOne.route) { ScreenOne(navigationController) }
                        composable(route = Routes.ScreenTwo.route) { ScreenTwo(navigationController) }
                        composable(route = Routes.ScreenThree.route) {
                            ScreenThree(
                                navigationController
                            )
                        }
                        composable(
                            route = Routes.ScreenFour.route,
                            arguments = listOf(navArgument("score") {
                                type = NavType.IntType
                            })
                        ) { navBackStackEntry ->
                            ScreenFour(
                                navigationController,
                                navBackStackEntry.arguments?.getInt("score") ?: 0
                            )
                        }
                        composable(
                            route = Routes.ScreenFive.route,
                            arguments = listOf(navArgument("title") {
                                defaultValue = "Hola Mundo"
                            })
                        ) { navBackStackEntry ->
                            ScreenFive(
                                navigationController,
                                navBackStackEntry.arguments?.getString("title")
                            )
                        }
                    }*/

                    MediaListView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MonkeyFilmAppTheme {}
}

