package sdev.mediamaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun RegisterScreen(goBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var loading by remember { mutableStateOf(false) }

    var errorNumber by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // Usa el color de fondo del tema
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title of the registration screen
        Text(
            "Register",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(16.dp))
        // Input fields for registration
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("User name") },
            singleLine = true,
            enabled = !loading,
            isError = (errorNumber == 1 || username.isEmpty() && errorNumber == 5)
        )
        if (errorNumber == 1 && error != null) {
            Spacer(Modifier.height(4.dp))
            Text(error!!, color = MaterialTheme.colorScheme.error)
        }
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            enabled = !loading,
            isError = (errorNumber == 2 || errorNumber == 3 || password.isEmpty() && errorNumber == 5)
        )
        if (errorNumber == 2 && error != null) {
            Spacer(Modifier.height(4.dp))
            Text(error!!, color = MaterialTheme.colorScheme.error)
        }
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            enabled = !loading,
            isError = (errorNumber == 3 || confirmPassword.isEmpty() && errorNumber == 5)
        )
        if (errorNumber == 3 && error != null) {
            Spacer(Modifier.height(4.dp))
            Text(error!!, color = MaterialTheme.colorScheme.error)
        }
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            enabled = !loading,
            isError = (errorNumber == 4 || email.isEmpty() && errorNumber == 5)
        )
        if (errorNumber == 5 && error != null) {
            Spacer(Modifier.height(4.dp))
            Text(error!!, color = MaterialTheme.colorScheme.error)
        }
        Spacer(Modifier.height(16.dp))
        // Button to trigger or cancel registration
        Row() {
            Button(
                onClick = {
                    loading = true
                },
                enabled = !loading
            ) {
                if (loading) {
                    if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                        errorNumber = 5
                        error = "Todos los campos son obligatorios"
                        Text("Register")
                        loading = false
                    } else if (username.length < 3) {
                        errorNumber = 1
                        error = "El nombre de usuario debe tener al menos 3 caracteres"
                        Text("Register")
                        loading = false
                    } else if (password.length < 6) {
                        errorNumber = 2
                        error = "La contraseña debe tener al menos 6 caracteres"
                        Text("Register")
                        loading = false
                    } else if (password != confirmPassword) {
                        errorNumber = 3
                        error = "Las contraseñas no coinciden"
                        Text("Register")
                        loading = false
                    } else {
                        CircularProgressIndicator(Modifier.size(30.dp), strokeWidth = 2.dp)
                        error = null
                        errorNumber = 0
                        // Show a loading indicator while registering
                        Text(" Registering")
                        // Check register data with server API

                    }
                } else {
                    Text("Register")
                }
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = {
                print("Canceling registration")
                goBack()
            })
            {
                Text("Cancel")
            }
        }
    }
}