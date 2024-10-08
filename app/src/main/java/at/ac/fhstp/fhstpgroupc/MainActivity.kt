package at.ac.fhstp.fhstpgroupc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import at.ac.fhstp.fhstpgroupc.ui.MainApp
import at.ac.fhstp.fhstpgroupc.ui.theme.FHSTPGroupCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FHSTPGroupCTheme {
                MainApp()
            }
        }
    }
}
