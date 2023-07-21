package ui.login

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.theme.BrighterBlack
import ui.theme.buttonSize
import ui.theme.roundComponent

@Composable
fun loginField(navigateToHome : () -> Unit, modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        OutlinedTextField(
            label = { Text("Username") },
            value = username,
            onValueChange = {username = it},
            leadingIcon = { Icon(imageVector = Icons.Rounded.Person, contentDescription = "", tint = Color.LightGray) },
            colors = textFieldItemColor(),
            shape = RoundedCornerShape(roundComponent),
            singleLine = true,
            modifier = modifier.fillMaxWidth()

        )
        OutlinedTextField(
            label = { Text("Password") },
            value = password,
            onValueChange = { password = it },
            colors = textFieldItemColor(),
            shape = RoundedCornerShape(roundComponent),
            leadingIcon = { Icon(imageVector = Icons.Rounded.Lock, contentDescription = null, tint = Color.LightGray) },
            singleLine = true,
            modifier = modifier.fillMaxWidth()

        )
        Button(
            onClick = {navigateToHome()},
            content = { Text("LOGIN") },
            shape = RoundedCornerShape(26.dp),
            colors = buttonItemColor(),
            modifier = modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .heightIn(buttonSize),
        )
    }
}

@Composable private fun textFieldItemColor() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = BrighterBlack,
    unfocusedBorderColor = BrighterBlack,
    cursorColor = BrighterBlack,
    focusedLabelColor = BrighterBlack
)
@Composable private fun buttonItemColor() = ButtonDefaults.buttonColors(
    backgroundColor = BrighterBlack,
    contentColor = Color.White
)

@Preview
@Composable
fun loginFieldPrev() {
    loginField({})
}