package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.room.NoteDataBaseProvider
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val database = NoteDataBaseProvider.getNoteDataBase(this)
            val repository = NoteRepository(database.noteDao())
            val factory = ViewModelFactory(repository)
            val viewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

           SetUpNavGraph(viewModel)
        }
    }
}

