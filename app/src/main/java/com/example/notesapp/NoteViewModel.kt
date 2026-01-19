package com.example.notesapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.room.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel (private val repository: NoteRepository): ViewModel(){


    val notes = repository.getNotes()


    fun getNoteById(id: Int): Flow<Note>{
        return  repository.getNoteById(id)
    }

    fun addNotes(title: String?, desc: String?){
        viewModelScope.launch {
            repository.addNotes(Note(title,desc))
        }
    }

    fun updateNote(id: Int,title: String?,desc: String?){
        viewModelScope.launch {
            repository.addNotes(Note(title, description = desc,id))
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            repository.delete(note)
        }
    }





}