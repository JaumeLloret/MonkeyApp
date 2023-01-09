package com.jle.monkeyfilmapp.ui

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jle.monkeyfilmapp.login.ui.LoginScreen
import com.jle.monkeyfilmapp.login.ui.LoginViewModel
import com.jle.monkeyfilmapp.register.ui.RegisterScreen
import com.jle.monkeyfilmapp.register.ui.RegisterViewModel
import com.jle.monkeyfilmapp.ui.model.Routes


@Composable
fun Nav(loginViewModel : LoginViewModel, registerViewModel : RegisterViewModel) {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Routes.LoginScreen.route
    ) {
        composable(route = Routes.LoginScreen.route) { LoginScreen(loginViewModel, navigationController) }
        composable(route = Routes.RegisterScreen.route) { RegisterScreen(registerViewModel, navigationController) }

        /*composable(
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
        }*/
    }
}

/*
@Composable
fun ScreenThree(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Pantalla 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenFour.createRoute(4)) })
    }
}

@Composable
fun ScreenFour(navigationController: NavHostController, score: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = "Pantalla 4 -> $score",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenFive.route) })
    }
}

@Composable
fun ScreenFive(navigationController: NavHostController, title: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Pantalla 5 -> $title", modifier = Modifier.align(Alignment.Center))
    }
}
*/