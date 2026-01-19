package com.example.notesapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun UpdateScreen(id:Int?,navController: NavController,viewModel: NoteViewModel) {

    if (id == null) return

    val notesById by viewModel.getNoteById(id) .collectAsState(initial = null)

    notesById?.let {

        var notesTitle by rememberSaveable { mutableStateOf(it.title) }

        var notesDescription by rememberSaveable { mutableStateOf(it.description) }

        Column(
            modifier = Modifier.fillMaxSize().systemBarsPadding().padding(7.dp).background(Color(0xFFF5F9FF)),
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {

            Text("Notes ", fontSize = 28.sp, fontWeight = FontWeight.Bold)

            TextField(
                value = notesTitle ?: "No Title",
                onValueChange = { newTitle ->
                    notesTitle = newTitle
                },

                label = { Text("Update Title") }, modifier = Modifier.fillMaxWidth(0.9f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    focusedBorderColor = Color.Black
                )

            )

            TextField(
                notesDescription ?: "No description", onValueChange = { newDesc ->
                    notesDescription = newDesc
                }, label = { Text("Update Description") }, modifier = Modifier.fillMaxWidth(0.9f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    focusedBorderColor = Color.Black
                )
            )

            Button(
                onClick = {

                    if (notesTitle?.isNotEmpty() == true && notesDescription?.isNotEmpty() == true) {

                        viewModel.updateNote (id,notesTitle, notesDescription,)

                        navController.popBackStack()
                    }
                },

                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            )
            {
                Text("Update Notes")
            }
        }
    }
}

@Preview(showBackground = true)

@Composable
fun PreviewUpdateScreen(){
    //UpdateScreen()
}
