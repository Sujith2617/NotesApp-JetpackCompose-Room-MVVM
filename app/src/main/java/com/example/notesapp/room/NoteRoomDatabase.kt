package com.example.notesapp.room



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract  class NoteRoomDatabase : RoomDatabase(){

    abstract fun noteDao(): NoteDao

}
object NoteDataBaseProvider{

  private  var Instances : NoteRoomDatabase? = null

    fun getNoteDataBase(context: Context): NoteRoomDatabase{
        return Instances ?: synchronized(this){

            val instance = Room.databaseBuilder(context.applicationContext,
                NoteRoomDatabase::class.java,"notedb").
                fallbackToDestructiveMigration().build()
                Instances = instance
            instance
        }
    }
}