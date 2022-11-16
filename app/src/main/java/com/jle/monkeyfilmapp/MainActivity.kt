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
import com.jle.monkeyfilmapp.component.MediaGridView
import com.jle.monkeyfilmapp.component.MediaListView
import com.jle.monkeyfilmapp.component.MediaListViewWithCustomControl
import com.jle.monkeyfilmapp.ui.theme.MonkeyFilmAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonkeyFilmAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //MediaListView()
                    MediaListViewWithCustomControl()
                    //MediaGridView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MonkeyFilmAppTheme {
    }
}

