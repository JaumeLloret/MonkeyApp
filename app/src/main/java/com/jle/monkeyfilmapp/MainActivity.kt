package com.jle.monkeyfilmapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jle.monkeyfilmapp.login.ui.LoginScreen
import com.jle.monkeyfilmapp.login.ui.LoginViewModel
import com.jle.monkeyfilmapp.map.ui.MapScreen
import com.jle.monkeyfilmapp.register.ui.MapViewModel
import com.jle.monkeyfilmapp.register.ui.RegisterScreen
import com.jle.monkeyfilmapp.register.ui.RegisterViewModel
import com.jle.monkeyfilmapp.ui.model.Routes
import com.jle.monkeyfilmapp.ui.theme.MonkeyFilmAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    private val loginViewModel : LoginViewModel by viewModels()
    private val registerViewModel : RegisterViewModel by viewModels()
    private val mapViewModel : MapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationController = rememberNavController()

            MonkeyFilmAppTheme {
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.LoginScreen.route
                ) {
                    composable(route = Routes.LoginScreen.route) { LoginScreen(loginViewModel, navigationController) }
                    composable(route = Routes.RegisterScreen.route) { RegisterScreen(registerViewModel, navigationController) }
                    composable(route = Routes.MapScreen.route) { MapScreen(mapViewModel, navigationController) }
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

