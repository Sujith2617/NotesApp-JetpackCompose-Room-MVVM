package com.example.notesapp

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NotesInputScreen(navController: NavController,viewModel: NoteViewModel) {



    var notesTitle by rememberSaveable { mutableStateOf("") }

    var notesDescription by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().systemBarsPadding().padding(7.dp).background(Color(0xFFF5F9FF)).verticalScroll(
            rememberScrollState()
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Notes ", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        TextField(
            value = notesTitle,
            onValueChange = { newTitle -> notesTitle = newTitle },
            label = { Text("Title") }, modifier = Modifier.fillMaxWidth(0.9f),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                focusedLabelColor = Color.Black,
                focusedBorderColor = Color.Black
            )

        )
        TextField(
            notesDescription, onValueChange = { newDesc ->
            notesDescription = newDesc
        }, label = { Text("Description") }, modifier = Modifier.fillMaxWidth(0.9f),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                focusedLabelColor = Color.Black,
                focusedBorderColor = Color.Black
            )
        )


        Button(
            onClick = {
                if (notesTitle.isNotEmpty() && notesDescription.isNotEmpty()) {

                    viewModel.addNotes(notesTitle, notesDescription)

                    navController.popBackStack()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        )
        {
            Text("Save Notes",)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotesInputScreen(){
    val navController = rememberNavController()

    NotesInputScreen(navController, viewModel =viewModel())

}