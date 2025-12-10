package mx.ipn.upiicsa.programacionmovil.citas.screens

import android.util.Base64
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mx.ipn.upiicsa.programacionmovil.citas.R
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Mostrar snackbar cuando hay error
    LaunchedEffect(errorMessage) {
        errorMessage?.let { message ->
            snackbarHostState.showSnackbar(message)
            // Limpiar mensaje después de 3 segundos
            kotlinx.coroutines.delay(3000)
            errorMessage = null
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = stringResource(R.string.inicio_de_sesion),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Card para el formulario
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Campo de usuario
                    OutlinedTextField(
                        value = username,
                        onValueChange = {
                            username = it
                            errorMessage = null
                        },
                        label = { Text(stringResource(R.string.login)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        isError = errorMessage != null
                    )

                    // Campo de contraseña
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            errorMessage = null
                        },
                        label = { Text(stringResource(R.string.password)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        isError = errorMessage != null
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Botón de inicio de sesión
                    Button(
                        onClick = {
                            if (username.isBlank() || password.isBlank()) {
                                errorMessage = "Por favor completa todos los campos"
                                return@Button
                            }

                            isLoading = true

                            coroutineScope.launch {
                                // Simular llamada a API
                                kotlinx.coroutines.delay(1000)

                                // Validación simple (reemplaza con tu lógica real)
                                if (username == "admin" && base64(sha512(password)) == "N2ZjZjRiYTM5MWM0ODc4NGVkZGU1OTk4ODlkNmUzZjFlNDdhMjdkYjM2ZWNjMDUwY2M5MmYyNTliZmFjMzhhZmFkMmM2OGExYWU4MDRkNzcwNzVlOGZiNzIyNTAzZjNlY2EyYjJjMTAwNmVlNmY2YzdiNzYyOGNiNDVmZmZkMWQ=") {
                                    onLoginSuccess() // Navegación exitosa
                                } else {
                                    errorMessage = "Credenciales incorrectas"
                                }

                                isLoading = false
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        enabled = !isLoading
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(stringResource(R.string.iniciar_sesion))
                        }
                    }

                    // Enlace para registro
                    TextButton(
                        onClick = onRegisterClick,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(
                            text = stringResource(R.string.rigistrarse),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Información adicional
            Text(
                text = "Versión 1.0.0",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}

fun sha512(cadena:String): String {
    val bytes = cadena.toByteArray(Charsets.UTF_8)
    val md = MessageDigest.getInstance("SHA-512")
    val digest = md.digest(bytes)
    return digest.fold("") { str, byte -> str + "%02x".format(byte)}
}

fun base64(encodedString: String): String {
    var tag = "base64"
    var encodedString = Base64.encodeToString(encodedString.toByteArray(StandardCharsets.UTF_8), Base64.DEFAULT)
    //val decodedString = String(decodedBytes, Charsets.UTF_8)
    Log.i(tag,"Another: N2ZjZjRiYTM5MWM0ODc4NGVkZGU1OTk4ODlkNmUzZjFlNDdhMjdkYjM2ZWNjMDUwY2M5MmYyNTliZmFjMzhhZmFkMmM2OGExYWU4MDRkNzcwNzVlOGZiNzIyNTAzZjNlY2EyYjJjMTAwNmVlNmY2YzdiNzYyOGNiNDVmZmZkMWQ=")
    Log.i(tag,"Encoded: $encodedString");
    encodedString = encodedString.replace("\n", "")// Output: Hello, Kotlin!
    Log.i(tag,"Empty: $encodedString");
    return encodedString
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    mx.ipn.upiicsa.programacionmovil.citas.ui.theme.CitasTheme {
        LoginScreen()
    }
}