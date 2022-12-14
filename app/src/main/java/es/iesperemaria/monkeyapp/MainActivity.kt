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
import com.jle.monkeyfilmapp.login.ui.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import es.iesperemaria.monkeyapp.login.ui.LoginViewModel
import es.iesperemaria.monkeyapp.ui.composable.MediaGridView
import es.iesperemaria.monkeyapp.ui.composable.MediaListView
import es.iesperemaria.monkeyapp.ui.composable.MediaListViewWithCustomControl
import es.iesperemaria.monkeyapp.ui.theme.MonkeyAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonkeyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen(loginViewModel)
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