package com.jefisu.composedestinationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefisu.composedestinationdemo.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinationsNavHost(navGraph = NavGraphs.root)
        }
    }
}

@Destination(start = true)
@Composable
fun StartScreen(
    navigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            navigator.navigate(
                ProfileScreenDestination(
                    User(
                        name = "Jeferson",
                        age = 19
                    )
                )
            )
        }) {
            Text(text = "Next screen")
        }
    }
}

@Destination
@Composable
fun ProfileScreen(
    user: User
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = user.name, fontSize = 28.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = user.age.toString(), fontSize = 28.sp)
    }
}
