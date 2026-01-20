package com.example.notesapp.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteTable")
data class Note(

    val title: String?,
    val description: String?,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    )

