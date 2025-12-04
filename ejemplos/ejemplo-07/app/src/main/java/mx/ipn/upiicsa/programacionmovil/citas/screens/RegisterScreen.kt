package mx.ipn.upiicsa.programacionmovil.citas.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onBack: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registro de Usuario") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulario de Registro",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Aquí irían los campos para registrar un nuevo usuario:\n" +
                        "• Nombre completo\n" +
                        "• Correo electrónico\n" +
                        "• Contraseña\n" +
                        "• Confirmar contraseña\n" +
                        "• Teléfono\n" +
                        "• Etc.",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón simulado de registro
            Button(
                onClick = {
                    // Aquí iría la lógica de registro
                    onRegisterSuccess()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrarse")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para regresar
            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                enabled = true
            ) {
                Text("Regresar al Login")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    mx.ipn.upiicsa.programacionmovil.citas.ui.theme.CitasTheme {
        RegisterScreen()
    }
}