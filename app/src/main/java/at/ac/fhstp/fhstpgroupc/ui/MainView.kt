package at.ac.fhstp.fhstpgroupc.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import at.ac.fhstp.fhstpgroupc.R
import at.ac.fhstp.fhstpgroupc.SecondActivity
import at.ac.fhstp.fhstpgroupc.ui.theme.FHSTPGroupCTheme

enum class Screens {
    Home,
    Overview
}

@Composable
fun MainApp(mainViewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    val context = LocalContext.current

    val state by mainViewModel.calculationUiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->

        NavHost(navController, Screens.Home.name) {
            composable(Screens.Home.name) {
                Box(Modifier.padding(innerPadding)) {
                    Calculation(state.result, {
                        num1Text, num2Text -> mainViewModel.onCalculate(num1Text, num2Text)
                    })
                }
            }
            composable(Screens.Overview.name) {
                Column(Modifier.padding(innerPadding)) {
                    Greeting(
                        name = "Android",
                        modifier = Modifier
                    )
                    Button(onClick = {
                        val intent = Intent(context, SecondActivity::class.java)
                        intent.putExtra("string-data", "Hello from MainActivity")
                        context.startActivity(intent)
                    }) {
                        Text("Call second activity")
                    }
                }
            }
        }

        /*// padding is important to move composable below System UI
        Column(Modifier.padding(innerPadding)) {
            Greeting(
                name = "Android",
                modifier = Modifier
            )
            Calculation()
        }*/
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val activeRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: Screens.Home.name
    val activeScreen = Screens.valueOf(activeRoute)

    NavigationBar {
        NavigationBarItem(
            selected = activeScreen == Screens.Home,
            onClick = { navController.navigate(Screens.Home.name) },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = activeScreen == Screens.Overview,
            onClick = { navController.navigate(Screens.Overview.name) },
            icon = { Icon(imageVector = Icons.AutoMirrored.Default.List, contentDescription = "Overview") },
            label = { Text("Overview") }
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Calculation(result: Double, onCalculate: (String, String) -> Unit, modifier: Modifier = Modifier) {
    var firstNumText by remember { mutableStateOf("") }
    var secondNumText by remember { mutableStateOf("") }

    Column() {
        OutlinedTextField(firstNumText, { firstNumText = it }, label = { Text("Number 1") })
        OutlinedTextField(secondNumText, { secondNumText = it }, label = { Text("Number 2") })
        Button(onClick = {
            onCalculate(firstNumText, secondNumText)
        }) {
            Text("Calculate!")
        }
        Row {
            Text("Result: ")
            Spacer(Modifier.width(16.dp))
            Text("$result")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(colorResource(R.color.primary))
            .padding(dimensionResource(R.dimen.small_padding))
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(text = stringResource(R.string.greeting))
        Image(
            painterResource(R.drawable.baseline_battery_alert_24),
            contentDescription = stringResource(R.string.battery_warning)
        )
    }
}

@Preview(showBackground = true, locale = "de")
@Composable
fun GreetingPreview() {
    FHSTPGroupCTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnDemo() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .height(50.dp)
        ) {
            Text("Hi there")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .height(100.dp)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .weight(1f)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .weight(5f)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .weight(1f)
        )
        Row {
            Column {
                Box {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowDemo() {
    Row(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Green)
                .height(50.dp)
        ) {
            Text("Hi there")
        }
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Yellow)
                .height(100.dp)
        )
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Red)
                .weight(1f)
        )
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Blue)
                .weight(5f)
        )
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Black)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Exercise2() {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight()
            )
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight()
            )
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight()
            )
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight()
            )
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight()
            )
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}