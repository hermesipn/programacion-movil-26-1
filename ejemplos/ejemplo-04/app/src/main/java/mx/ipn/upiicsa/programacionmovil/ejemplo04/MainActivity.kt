package mx.ipn.upiicsa.programacionmovil.ejemplo04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.ipn.upiicsa.programacionmovil.ejemplo04.ui.theme.AdministradorDeTareasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdministradorDeTareasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    TaskManagerApp();
                }
            }
        }
    }
}

@Composable
fun TaskManagerApp() {
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        val imagePainter = painterResource(R.drawable.ic_task_completed)
        Image(
            painter = imagePainter,
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = "All task completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Preview - Administrador de tareas"
)
@Composable
fun GreetingPreview() {
    AdministradorDeTareasTheme {
        TaskManagerApp();
    }
}