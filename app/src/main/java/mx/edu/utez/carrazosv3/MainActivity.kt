package mx.edu.utez.carrazosv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mx.edu.utez.carrazosv3.ui.Navigation
import mx.edu.utez.carrazosv3.ui.theme.CalculadoraMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraMVVMTheme {
                Navigation()
            }
        }
    }
}