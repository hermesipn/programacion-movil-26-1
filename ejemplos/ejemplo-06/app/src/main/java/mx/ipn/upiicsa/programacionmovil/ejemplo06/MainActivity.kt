package mx.ipn.upiicsa.programacionmovil.ejemplo06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.ipn.upiicsa.programacionmovil.ejemplo06.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresentationCardTheme {
                Surface (modifier = Modifier.fillMaxSize().statusBarsPadding()) {
                    PresentationCard();
                }
            }
        }
    }
}

@Composable
fun PresentationCard() {
    //val painter = painterResource()
    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val imagePainter = painterResource(R.drawable.android_logo)
        Image(
            painter = imagePainter,
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier.padding(5.dp)
        )
            Text(
                text = "Hermes Francisco Montes Casiano",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
                )

            Text(
                text = "Doctor",
                textAlign = TextAlign.Center)

    }
    Column (
        modifier = Modifier.padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Row {
            Icon(modifier = Modifier.padding(start = 100.dp), imageVector = Icons.Filled.Call, contentDescription = "Phone")
            Text(
                text = "55 55 55 55 55"
            )
        }
        Row {
            Icon(modifier = Modifier.padding(start = 100.dp), imageVector = Icons.Filled.Person, contentDescription = "Phone")
            Text(
                text = "@hermes.montes"
            )
        }
        Row {
            Icon(modifier = Modifier.padding(start = 100.dp), imageVector = Icons.Filled.Email, contentDescription = "Phone")
            Text(
                text = "hermes.montes@gmail.com"
            )
        }
    }
}

@Composable
fun OwnerCard() {

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Preview - Presentation card"
    )
@Composable
fun GreetingPreview() {
    PresentationCardTheme {
        PresentationCard()
    }
}