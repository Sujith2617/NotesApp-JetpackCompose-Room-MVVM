package com.example.notesapp

sealed class Screens(val routes: String){

    data object HomeScreen : Screens("homeScreen")

    data object NotesInputScreen: Screens("notesInputScreen")

    data object UpdateScreen: Screens("updateScreen/{id}"){

        fun passingData( id: Int): String{
            return "updateScreen/$id"
        }

    }

}