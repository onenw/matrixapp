package com.william.matrixapp.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(navController: NavHostController) {




    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password  by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showSuccess by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Sign Up", style = MaterialTheme.typography.titleLarge )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()


        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword = it},
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

      if (showError){
          Text("Password do not match", color = Color.Red)
          Spacer(modifier = Modifier.height(8.dp))
      }
if (showSuccess){
    Text("Registered successfully", color = Color.Green)
    Spacer(modifier = Modifier.height(8.dp))
}

        Button(
            onClick = {
                if (username.isNotEmpty()&& email.isNotEmpty() &&
                    password.isNotEmpty() && password == confirmPassword){
                    showError = false
                    showSuccess = true
                    navController.navigate("login"){
                        popUpTo("register"){inclusive = true}
                    }
                }else{
                    showError= true
                }
             },
            modifier = Modifier.fillMaxWidth()

        ) {
Text("Register")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = {navController.navigate("login")}) {
            Text("User is already registered")
        }

    }
}