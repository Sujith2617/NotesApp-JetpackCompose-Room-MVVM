package com.example.notesapp.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao{

    @Upsert
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM noteTable WHERE id = :id ")
    fun getNoteById(id: Int): Flow<Note>

    @Query("SELECT * FROM noteTable")
    fun getNote(): Flow<List<Note>>

}
