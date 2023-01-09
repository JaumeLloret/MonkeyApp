package com.jle.monkeyfilmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jle.monkeyfilmapp.login.ui.LoginScreen
import com.jle.monkeyfilmapp.login.ui.LoginViewModel
import com.jle.monkeyfilmapp.register.ui.RegisterScreen
import com.jle.monkeyfilmapp.register.ui.RegisterViewModel
import com.jle.monkeyfilmapp.ui.Nav
import com.jle.monkeyfilmapp.ui.theme.MonkeyFilmAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel : LoginViewModel by viewModels()
    private val registerViewModel : RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonkeyFilmAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Nav(loginViewModel = loginViewModel, registerViewModel = registerViewModel)
                    //MediaListView()
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

