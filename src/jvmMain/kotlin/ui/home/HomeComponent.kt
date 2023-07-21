package ui.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Book
import data.model.BookSample
import ui.theme.DarkBlue
import ui.theme.Red
import ui.theme.buttonSize
import ui.theme.roundComponent

@Composable
fun HomeComponent(logout: () -> Unit, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            TopBar(logout)
            Row(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                InputPropertyField()
                ListBookTab()
            }
        }
}

@Composable
fun TopBar(logout : () -> Unit) {
    TopAppBar(
        title = {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Home", fontSize = 24.sp)
                }
        },
        backgroundColor = DarkBlue,
        contentColor = Color.White,
        actions = {
            IconButton(
                onClick = {logout()},
                content = { Icon(imageVector = Icons.Rounded.ExitToApp, contentDescription = null, tint = Color.White) },
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 16.dp)
            )
        },
        modifier = Modifier.heightIn(58.dp)
    )
}

@Composable
fun InputPropertyField(modifier: Modifier = Modifier) {
    var namaBuku by remember { mutableStateOf("") }
    var penerbit by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(0.5f)
    ) {
        OutlinedTextField(
            value = namaBuku,
            onValueChange = {namaBuku = it},
            label = { Text("Nama Buku") },
            shape = RoundedCornerShape(roundComponent),
            colors = TextFieldItemColors(),
            modifier = modifier.fillMaxWidth().padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = penerbit,
            onValueChange = {penerbit = it},
            label = { Text("Penerbit") },
            shape = RoundedCornerShape(roundComponent),
            colors = TextFieldItemColors(),
            singleLine = true,
            modifier = modifier.fillMaxWidth().padding(vertical = 8.dp)
        )
        Row {
            Button(
                content = { Text("SAVE") },
                onClick = {},
                colors = ButtonItemColor(),
                modifier = ButtonModifier(),
                shape = RoundedCornerShape(roundComponent)
            )
            Button(
                content = { Text("EDIT") },
                onClick = {},
                colors = ButtonItemColor(),
                modifier = ButtonModifier(),
                shape = RoundedCornerShape(roundComponent)
            )
        }
        Button(
            content = { Text("DELETE") },
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Red,
                contentColor = Color.White
            ),
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
                .heightIn(buttonSize),
            shape = RoundedCornerShape(roundComponent),
        )
    }
}

@Composable
fun ListBookTab(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    var bookList by  remember { mutableStateOf(BookSample.sample) }
    Column(
        modifier = modifier
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxSize()
            .border(2.dp, DarkBlue, shape = RoundedCornerShape(18.dp))
            .padding(8.dp),
    ) {
        SearchBar()
        ListHeader()
        LazyColumn {
            item {
                BookSample.sample.forEach {
                    BookItem(it)
                }
            }
        }
    }
}

@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }
    OutlinedTextField(
        value = query,
        onValueChange = {query = it},
        placeholder = {
            Row(horizontalArrangement = Arrangement.Center) {
                Text("ID/Book Name/Publisher")
            }
        },
        colors = TextFieldItemColors(),
        shape = RoundedCornerShape(roundComponent),
        singleLine = true,
        leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = null, tint = DarkBlue) },
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    )
}

@Composable
fun BookItem(book : Book) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(book.id.toString())
        Text(book.bookName)
        Text(book.publisher)
    }
}
@Composable
fun ListHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("ID")
        Text("Book Name")
        Text("Publisher")
    }
}

@Composable private fun RowScope.ButtonModifier() = Modifier
    .padding(horizontal = 4.dp)
    .weight(0.5f)
    .heightIn(buttonSize)
@Composable private fun ButtonItemColor() = ButtonDefaults.buttonColors(
    backgroundColor = DarkBlue,
    contentColor = Color.White
)
@Composable private fun TextFieldItemColors() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = DarkBlue,
    unfocusedBorderColor = DarkBlue,
    cursorColor = DarkBlue,
    focusedLabelColor = DarkBlue,
    unfocusedLabelColor = DarkBlue,
)