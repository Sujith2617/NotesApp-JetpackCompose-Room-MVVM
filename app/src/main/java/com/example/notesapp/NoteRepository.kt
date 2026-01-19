package com.example.notesapp

import com.example.notesapp.room.Note
import com.example.notesapp.room.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepository (private val noteDao: NoteDao){


    suspend fun addNotes(note: Note){
        noteDao.upsertNote(note)
    }

    fun getNotes(): Flow<List<Note>>{
       return noteDao.getNote()
    }

    suspend fun delete(note: Note){
        noteDao.deleteNote(note)
    }


    fun getNoteById(id : Int): Flow<Note>{
        return noteDao.getNoteById(id)
    }
}