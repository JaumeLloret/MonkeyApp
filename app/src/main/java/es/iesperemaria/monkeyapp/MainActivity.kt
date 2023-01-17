package es.iesperemaria.monkeyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jle.monkeyfilmapp.login.ui.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import es.iesperemaria.monkeyapp.login.ui.LoginViewModel
import es.iesperemaria.monkeyapp.maps.ui.MapScreen
import es.iesperemaria.monkeyapp.maps.ui.MapViewModel
import es.iesperemaria.monkeyapp.ui.model.Routes
import es.iesperemaria.monkeyapp.ui.theme.MonkeyAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private val mapViewModel: MapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationController = rememberNavController()
            MonkeyAppTheme {
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.LoginScreen.route
                ) {
                    composable(route = Routes.LoginScreen.route) {
                        LoginScreen(
                            loginViewModel = loginViewModel,
                            navigationController = navigationController
                        )
                    }
                    composable(route = Routes.MapScreen.route) {
                        MapScreen(
                            mapViewModel = mapViewModel,
                            navigationController = navigationController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MonkeyAppTheme {
        Greeting("Android")
    }
}