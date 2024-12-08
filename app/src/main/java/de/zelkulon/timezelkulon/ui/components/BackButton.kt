/*
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.google.android.material.navigation.NavigationView

@Composable
fun BackButtonScreen(onBackPressed: () -> Unit) {
    val activity = LocalContext.current as? Activity


    BackHandler {
        // Handle the back button press
        onBackPressed()
    }

    // Your Compose UI
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("This is the BackButton Screen", modifier = Modifier.fillMaxSize())
        Button(onClick = { activity?.finish() }, modifier = Modifier.fillMaxSize()) {
            Text("Go back to MainActivity")
        }
    }

}

@Composable
fun MainAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                onNavigateToBackButtonScreen = {
                    navController.navigate("backButtonScreen")
                }
            )
        }
        composable("backButtonScreen") {
            BackButtonScreen(
                onBackPressed = { navController.popBackStack() }
            )
        }
    }
}
*/
