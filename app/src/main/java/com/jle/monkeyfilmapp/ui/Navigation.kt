package com.jle.monkeyfilmapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    }
}