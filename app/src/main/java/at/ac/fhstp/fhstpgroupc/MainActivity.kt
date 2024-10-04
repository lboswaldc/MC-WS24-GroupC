package at.ac.fhstp.fhstpgroupc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
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
        Box(Modifier.fillMaxWidth().background(Color.Green).height(50.dp)) {
            Text("Hi there")
        }
        Box(Modifier.fillMaxWidth().background(Color.Yellow).height(100.dp))
        Box(Modifier.fillMaxWidth().background(Color.Red).weight(1f))
        Box(Modifier.fillMaxWidth().background(Color.Blue).weight(5f))
        Box(Modifier.fillMaxWidth().background(Color.Black).weight(1f))
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
        Box(Modifier.fillMaxHeight().background(Color.Green).height(50.dp)) {
            Text("Hi there")
        }
        Box(Modifier.fillMaxHeight().background(Color.Yellow).height(100.dp))
        Box(Modifier.fillMaxHeight().background(Color.Red).weight(1f))
        Box(Modifier.fillMaxHeight().background(Color.Blue).weight(5f))
        Box(Modifier.fillMaxHeight().background(Color.Black).weight(1f))
    }
}