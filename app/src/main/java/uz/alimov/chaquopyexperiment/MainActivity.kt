package uz.alimov.chaquopyexperiment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chaquo.python.Python
import uz.alimov.chaquopyexperiment.ui.theme.ChaquopyExperimentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChaquopyExperimentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Experiment(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Experiment(modifier: Modifier = Modifier) {
    var sumSquares by remember { mutableDoubleStateOf(0.0) }
    var root by remember { mutableDoubleStateOf(0.0) }

    val python = Python.getInstance()
    val module = python.getModule("calculation")

    val pyObject = module.callAttr(
        "process_values",
        1.0,
        2.0,
        3.0
    )
    sumSquares = pyObject.asList()[0].toDouble()
    root = pyObject.asList()[1].toDouble()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Sum of Squares: $sumSquares")
        Text(text = "Root: $root")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChaquopyExperimentTheme {
        Experiment()
    }
}