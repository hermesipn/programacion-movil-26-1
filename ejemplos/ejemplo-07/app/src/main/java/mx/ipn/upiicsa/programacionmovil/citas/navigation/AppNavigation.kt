package mx.ipn.upiicsa.programacionmovil.citas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.ipn.upiicsa.programacionmovil.citas.screens.HomeScreen
import mx.ipn.upiicsa.programacionmovil.citas.screens.LoginScreen
import mx.ipn.upiicsa.programacionmovil.citas.screens.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        // Pantalla de Login
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    // Navega a la pantalla principal y limpia el back stack
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                },
                onRegisterClick = {
                    // Navega a la pantalla de registro
                    navController.navigate(Screen.Register.route)
                }
            )
        }

        // Pantalla Principal
        composable(Screen.Home.route) {
            HomeScreen(
                onLogout = {
                    // Regresa al login y limpia el back stack
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Pantalla de Registro
        composable(Screen.Register.route) {
            RegisterScreen(
                onBack = {
                    navController.popBackStack()
                },
                onRegisterSuccess = {
                    // Después de registrarse, regresa al login
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Register.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

// Definición de las rutas de la aplicación
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Register : Screen("register")
    object Cita : Screen ("cita")
}