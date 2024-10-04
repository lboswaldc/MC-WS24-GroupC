package at.ac.fhstp.fhstpgroupc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.ac.fhstp.fhstpgroupc.ui.theme.FHSTPGroupCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FHSTPGroupCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // padding is important to move composable below System UI
                    Column(Modifier.padding(innerPadding)) {
                        Greeting(
                            name = "Android",
                            modifier = Modifier
                        )
                        Calculation()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Calculation(modifier: Modifier = Modifier) {
    var firstNumText by remember { mutableStateOf("") }
    var secondNumText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    Column() {
        OutlinedTextField(firstNumText, { firstNumText = it }, label = { Text("Number 1") })
        OutlinedTextField(secondNumText, { secondNumText = it }, label = { Text("Number 2") })
        Button(onClick = {
            val num1 = firstNumText.toDoubleOrNull() ?: 0.0
            val num2 = secondNumText.toDoubleOrNull() ?: 0.0
            val sum = num1 + num2
            resultText = "$sum"
        }) {
            Text("Calculate!")
        }
        Row {
            Text("Result: ")
            Spacer(Modifier.width(16.dp))
            Text(resultText)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .background(colorResource(R.color.primary))
        .padding(dimensionResource(R.dimen.small_padding))
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(text = stringResource(R.string.greeting))
        Image(painterResource(R.drawable.baseline_battery_alert_24),
            contentDescription = stringResource(R.string.battery_warning)
        )
    }
}

@Preview(showBackground = true, locale="de")
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
                .height(50.dp)) {
            Text("Hi there")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .height(100.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .weight(1f))
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .weight(5f))
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .weight(1f))
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
                .height(50.dp)) {
            Text("Hi there")
        }
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Yellow)
                .height(100.dp))
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Red)
                .weight(1f))
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Blue)
                .weight(5f))
        Box(
            Modifier
                .fillMaxHeight()
                .background(Color.Black)
                .weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
private fun Exercise2() {
    Column (Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight())
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight())
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight())
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight())
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight())
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight())
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight())
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight())
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight())
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxHeight())
        }
    }
}